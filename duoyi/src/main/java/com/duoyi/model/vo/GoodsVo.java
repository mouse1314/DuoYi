package com.duoyi.model.vo;

import java.util.Date;

public class GoodsVo {

	 	private Integer id;

	    private Integer userId;

	    private String name;

	    private Float price;

	    private String describe;

	    private Integer result;

	    private Date time;
	    
	    private Integer cardId;

	    private Integer goodId;

	    private String img;

		public GoodsVo(Integer id, Integer userId, String name, Float price, String describe, Integer result, Date time,
				Integer cardId, Integer goodId, String img) {
			super();
			this.id = id;
			this.userId = userId;
			this.name = name;
			this.price = price;
			this.describe = describe;
			this.result = result;
			this.time = time;
			this.cardId = cardId;
			this.goodId = goodId;
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

		public Date getTime() {
			return time;
		}

		public void setTime(Date time) {
			this.time = time;
		}

		public Integer getCardId() {
			return cardId;
		}

		public void setCardId(Integer cardId) {
			this.cardId = cardId;
		}

		public Integer getGoodId() {
			return goodId;
		}

		public void setGoodId(Integer goodId) {
			this.goodId = goodId;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}
	    
	    
	    
}
