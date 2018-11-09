package com.duoyi.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.duoyi.model.po.GoodsGenerator;

public class GoodsVo {
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	 	private Integer id;

	    private Integer userId;

	    private String name;

	    private Float price;

	    private String describe;

	    private Integer result;

	    private String time;

	    private List<String> img;
	    
	    private String username;
	    
	    private String userImg;
	    
	    public GoodsVo(GoodsGenerator g,List<String> img){
	    	this.id = g.getId();
			this.userId = g.getUserId();
			this.name = g.getName();
			this.price = g.getPrice();
			this.describe = g.getDescribe();
			this.result = g.getResult();
			this.time = formatter.format(g.getTime());
			this.img = img;
	    }

		

		public GoodsVo() {
			super();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Float getPrice() {
			return price;
		}

		public void setPrice(Float price) {
			this.price = price;
		}

		public String getDescribe() {
			return describe;
		}

		public void setDescribe(String describe) {
			this.describe = describe;
		}

		public Integer getResult() {
			return result;
		}

		public void setResult(Integer result) {
			this.result = result;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public List<String> getImg() {
			return img;
		}

		public void setImg(List<String> img) {
			this.img = img;
		}

		@Override
		public String toString() {
			return "GoodsVo [formatter=" + formatter + ", id=" + id + ", userId=" + userId + ", name=" + name
					+ ", price=" + price + ", describe=" + describe + ", result=" + result + ", time=" + time + ", img="
					+ img + "]";
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getUserImg() {
			return userImg;
		}

		public void setUserImg(String userImg) {
			this.userImg = userImg;
		}
		
		

}
