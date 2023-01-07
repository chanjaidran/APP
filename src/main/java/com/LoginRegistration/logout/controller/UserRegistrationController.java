package com.LoginRegistration.logout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LoginRegistration.logout.Dto.UserregistrationDto;
import com.LoginRegistration.logout.Service.UsernService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired(required=false)
	UsernService service;
	
	
	 @ModelAttribute("user")
	    public UserregistrationDto userRegistrationDto() {
	        return new UserregistrationDto();
	    }
	
	@GetMapping
	public String showRegistration()
	{
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserregistrationDto userregistrationDto)
	{
		service.save(userregistrationDto);
		return "redirect:/registration?success";
	}
}
