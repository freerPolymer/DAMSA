package com.polymer.db.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SystemMenus {

	private String mid;
	private String parent;
	private String name;
	private String url;
	private String logo;
	private boolean enabled;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifyTime;

	public SystemMenus() {}

	public SystemMenus(String parent, String name, String url, String logo, boolean enabled, Date modifyTime) {
		this.parent = parent;
		this.name = name;
		this.url = url;
		this.logo = logo;
		this.enabled = enabled;
		this.modifyTime = modifyTime;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}
