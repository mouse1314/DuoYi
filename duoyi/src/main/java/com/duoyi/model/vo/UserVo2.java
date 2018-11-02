package com.duoyi.model.vo;

import java.util.Date;

import com.duoyi.model.po.UserGenerator;

public class UserVo2 {

	private Integer id;
    private String name;
    private String username;
    private String sex;
    private String img;
    private Integer money;
    private Integer age;
    private String mail;
    private String phone;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public UserVo2() {
		super();
	}
	public UserVo2(UserGenerator user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.username = user.getUsername();
		this.sex = user.getSex();
		this.img = user.getImg();
		this.money = user.getMoney();
		this.age = user.getAge();
		this.mail = user.getMail();
		this.phone = user.getPhone();
	}
	@Override
	public String toString() {
		return "UserVo2 [id=" + id + ", name=" + name + ", username=" + username + ", sex=" + sex + ", img=" + img
				+ ", money=" + money + ", age=" + age  + ", mail=" + mail + ", phone="
				+ phone + "]";
	}
    
    
    
    
    
}
