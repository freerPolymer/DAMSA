package com.polymer.db.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysUserMapper {

	@Select("select * from sys_user order by create_time,enabled desc")
	@Results({
			@Result(property = "name", column = "s_name"),
			@Result(property = "password",column = "s_password"),
			@Result(property = "createTime",column = "create_time")
	})
	List<SysUser> getAll();

	@Select("select * from sys_user where sid=#{sid}")
	@Results({
			@Result(property = "name", column = "s_name"),
			@Result(property = "password",column = "s_password"),
			@Result(property = "createTime",column = "create_time")
	})
	SysUser findById(String sid);

	@Select("select * from sys_user where s_name=#{name} and s_password=#{password}")
	@Results({
			@Result(property = "name", column = "s_name"),
			@Result(property = "password",column = "s_password")
	})
	SysUser find(String name,String password);

	@Delete("delete from  sys_user  where sid =#{sid}")
	int deleteById(String sid);

	@Update("update sys_user set s_name= #{name},s_password = #{password},enabled =#{enabled} where sid = #{sid}")
	int updateUserById(SysUser user);

	@Insert("insert into sys_user(sid,s_name,s_password,create_time) values(#{sid},#{name},#{password},now())")
	int saveUser(SysUser user);
}
