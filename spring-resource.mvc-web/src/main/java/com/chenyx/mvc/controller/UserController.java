package com.chenyx.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/getUser/{userName}")
	@ResponseBody
	public Object getUser(@PathVariable("userName") String userName) {
		System.out.println("-----------getUser-------------");
		Map<String,String> map = new HashMap<>();
		map.put("name",userName);
		map.put("age",12+"");
		return map;
	}
}
