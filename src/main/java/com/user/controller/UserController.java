package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.dto.LoginDTO;
import com.user.dto.ResetDTO;
import com.user.dto.UserDTO;
import com.user.entity.CountryEntity;
import com.user.service.IAddressService;
import com.user.service.IUserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IAddressService addressService;

	@GetMapping("/user-form")
	public String showUserForm(@RequestParam(required=false) String type,  @RequestParam(value = "msg", required = false) String msg, Model model) {
		model.addAttribute("user", new UserDTO());
		model.addAttribute("loginDto", new LoginDTO());

		if (msg != null && type!=null) {
			if (type.equals("0")) {
				model.addAttribute("registerMsg", msg);
				
			} else {
				model.addAttribute("loginMsg", msg);
			}

		}
		// Load all countries for the dropdown
		List<CountryEntity> countries = addressService.getAllCountries();
		model.addAttribute("countries", countries);
		return "user-form";
	}

	@PostMapping("/saveUser")
	public String saveUser(   @ModelAttribute("user") UserDTO userDTO, Model model) {
		boolean isSaved = userService.saveUser(userDTO);
		model.addAttribute("loginDto", new LoginDTO());
		if (isSaved) {
			return "redirect:/user-from?type=0&msg=user register successfully";
		} else {
			return "redirect:/user-form?type=0&msg=user not created try again...";
		}
	}

	@PostMapping("/login")
	public String login(@ModelAttribute LoginDTO loginDto, HttpServletRequest req) {
		// Verify user credentials
		Integer userId = userService.verifyUser(loginDto);
		// If user is not found, redirect to the login page
		if (userId == -1) {
			return "redirect:/user-form?type=1&msg=invalid credential"; // Redirect back to the login form
		}

		// Create or retrieve the session and set user attributes
		HttpSession session = req.getSession(true); // `true` creates a new session if one doesn't exist
		session.setAttribute("userId", userId);

		// Check if the password is active
		if (!userService.isPwdActive(userId)) {
			return "redirect:/reset-form"; // Redirect to the reset password form
		}

		// If everything is valid, redirect to the dashboard
		return "redirect:/dashboard";
	}

	@GetMapping("/reset-form")
	public String showResetForm(@ModelAttribute ResetDTO resetDTO) {
		return "reset-password-form";
	}

	@PostMapping("/reset")
	public String resetForm(HttpServletRequest req, @ModelAttribute ResetDTO resetDTO) {
		HttpSession session = req.getSession(false);
		Integer userId = (Integer) session.getAttribute("userId");
		boolean status = userService.resetPwd(userId, resetDTO);
		if (status) {
			return "redirect:/dashboard";
		}
		return "redirect:/reset-form";

	}

	@GetMapping("/dashboard")
	public String showDashboard(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null) {
			return "redirect:/user-form";
		}
		return "dashboard";
	}

	@PostMapping("/logout")
	public String logoutDashboard(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate(); // Invalidate the session to remove all session attributes
		}
		return "redirect:/user-form"; // Redirect to the login form
	}

//	@PostMapping("/show")
//	public ResponseEntity<String> showUserForm(@RequestBody UserDTO user) {
//		boolean status = userService.saveUser(user);
//		return ResponseEntity.ok("Success....");
//	}
//	
//	
//	@PostMapping("/reset")
//	public ResponseEntity<String> resetPassword(@RequestParam Integer userId,@RequestParam String oldPwd,@RequestParam String newPwd ) {
//			boolean reseted = userService.resetPwd(userId, oldPwd, newPwd);
//		return ResponseEntity.ok("Success....");
//	}

}
