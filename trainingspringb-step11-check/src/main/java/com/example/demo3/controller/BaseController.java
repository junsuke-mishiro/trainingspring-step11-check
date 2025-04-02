package com.example.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo3.model.Person;

@Controller
public class BaseController {

	@GetMapping("/")
	public String home(@ModelAttribute Person person) {
		return "form";
	}

	@PostMapping("/form")
	public String result(@Validated @ModelAttribute Person person,
			BindingResult result) {
		if (result.hasErrors()) {
			return "form";
		}
		return "result";
	}
}