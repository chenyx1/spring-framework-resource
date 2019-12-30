package com.chenyx.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
	@RequestMapping( "/index")
	public ModelAndView index() throws Exception {
		System.out.println("--------index--------");

		return new ModelAndView("Index");
	}
 }
