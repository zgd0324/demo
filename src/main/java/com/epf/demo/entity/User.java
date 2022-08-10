package com.epf.demo.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String username;
	
	private String password;
	
	private String imgcode;

	public String getUsername() {
		return username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImgcode() {
		return imgcode;
	}

	public void setImgcode(String imgcode) {
		this.imgcode = imgcode;
	}
	
}
