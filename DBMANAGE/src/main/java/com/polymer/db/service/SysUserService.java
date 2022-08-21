package com.polymer.db.service;

import com.polymer.db.mapper.SysUser;
import com.polymer.db.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

	@Autowired
	private SysUserMapper userMapper;

	public List<SysUser> findAll(){
		return userMapper.getAll();
	}

	public SysUser checkSysUser(String sid){
		return userMapper.findById(sid);
	}

	public SysUser checkSysUser(String name,String password){
		return userMapper.find(name,password);
	}

	public int save(SysUser user){
		if(userMapper.find(user.getName(), user.getPassword())!=null){
			return 0;
		}
		return userMapper.saveUser(user);
	}

	public int update(SysUser user){
		SysUser sysUser = userMapper.findById(user.getSid());
		if(sysUser==null){
			return 0;
		}
		return userMapper.updateUserById(user);
	}

	public int delete(String sid){
		return userMapper.deleteById(sid);
	}

}
