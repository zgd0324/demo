package com.epf.demo.entity;

import java.io.Serializable;

public class Test2 implements Serializable {
	
	private String name;
	
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Test2 [name=" + name + ", age=" + age + "]";
	}
	
}
