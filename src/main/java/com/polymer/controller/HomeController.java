package com.polymer.controller;

import com.sun.istack.internal.NotNull;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping(value = "/")
public class HomeController {
@NotNull
	@GetMapping(value = "index")
	public String index(){
		return "";
	}


}

