package com.polymer.db.service;

import com.polymer.db.mapper.SystemMenus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/menu/")
public class SysMenuController {

	@Autowired
	private RedisTemplate redisTemplate;

	@PostMapping("save")
	public String save(){
		ValueOperations<String, SystemMenus> operations = redisTemplate.opsForValue();

//		operations.set("",null);
		return "";
	}
}
