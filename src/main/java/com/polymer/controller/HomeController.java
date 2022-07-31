package com.polymer.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping(value = "/")
public class HomeController {
	@GetMapping(value = "index")
	public String index(){
		return "欢迎访问 ";
	}


}

