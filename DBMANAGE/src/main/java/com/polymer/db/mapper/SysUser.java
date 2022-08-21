package com.polymer.db.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SysUser {

	private String sid;
	private String name;
	private String password;
	private boolean enabled;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public SysUser() {
	}

	public SysUser(String sid, String name, String password, boolean enabled, Date createTime) {
		this.sid = sid;
		this.name = name;
		this.password = password;
		this.enabled = enabled;
		this.createTime = createTime;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
