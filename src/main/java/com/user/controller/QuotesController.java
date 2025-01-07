package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.user.service.IQuotesService;

@Controller
public class QuotesController {
	
	@Autowired
	private IQuotesService service;
	
	
	@GetMapping("/quotes")
	public String quotes(){
		String ramdomQuotes = service.getRandomQuotes();
		return ramdomQuotes;
	}

}
