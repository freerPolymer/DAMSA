package com.polymer.db.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polymer.db.base.IConstant;
import com.polymer.db.mapper.SysUser;
import com.polymer.db.service.SysUserService;
import com.polymer.db.util.CRPUtils;
import com.polymer.db.util.CodecsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/system/user/")
public class sysUserController {

	@Autowired
	private SysUserService userService;
	String json="{}";

	private static final ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.writer(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
	}

	@RequestMapping(value = "findSysUser",method = RequestMethod.POST)
	public String findSysUser(){
		List<SysUser> users=userService.findAll();
		try {
			json=mapper.writeValueAsString(users);
		} catch (Exception e) {}
		return json;
	}

	@RequestMapping(value = "checkUser",method = RequestMethod.POST)
	public String checkUser(@RequestParam(value = "name")String name,@RequestParam(name = "password")String password){
		password= CodecsUtil.MD5(password,null);//明文加密
		SysUser user= userService.checkSysUser(name,password);
		try {
			json=mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
		}
		return json;
	}

	@PostMapping("save")
	public String save( SysUser user){
		user.setPassword(CodecsUtil.MD5(user.getPassword(),null));
		String sourceStr=IConstant.NUMBER_STR+IConstant.UPPER_ABC_STR+System.currentTimeMillis();
		user.setSid(CRPUtils.getRandomChar(sourceStr,32));
		int rs= userService.save(user);
		try {
			json=mapper.writeValueAsString(rs);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return json;
	}

	@PostMapping("update")
	public String update( SysUser user){
		user.setPassword(CodecsUtil.MD5(user.getPassword(),null));
		int rs= userService.update(user);
		try {
			json= mapper.writeValueAsString(rs);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return json;
	}

}
