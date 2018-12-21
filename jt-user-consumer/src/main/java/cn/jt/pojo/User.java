package cn.jt.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class User {
	
	private Long id;
	private String name;
	private String birthday;
	private String address;
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
