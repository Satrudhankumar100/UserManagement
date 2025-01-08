package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.user.dto.QuotesDTO;
import com.user.service.IQuotesService;

@Controller
public class QuotesController {
	
	@Autowired
	private IQuotesService service;
	
	
	@GetMapping("/quotes")
	public QuotesDTO quotes(){
		QuotesDTO randomQuotes = service.getRandomQuotes();
		return randomQuotes;
	}
	
	

}
