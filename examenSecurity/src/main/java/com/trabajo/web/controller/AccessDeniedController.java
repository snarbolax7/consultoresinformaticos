package com.trabajo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {

	@GetMapping(value="/accessDenied")
	public String accessDenied(){
		return "accessDenied";
	}
}
