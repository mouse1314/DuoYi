package com.duoyi.model.po;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GoodsGenerator implements Serializable {
    private Integer id;

    private Integer userId;

    private String name;

    private Float price;

    private String describe;

    private Integer result;

    private Date time;

    private static final long serialVersionUID = 1L;

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
        this.name = name == null ? null : name.trim();
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
        this.describe = describe == null ? null : describe.trim();
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

	@Override
	public String toString() {
		return "GoodsGenerator [id=" + id + ", userId=" + userId + ", name=" + name + ", price=" + price + ", describe="
				+ describe + ", result=" + result + ", time=" + time + "]";
	}

	public GoodsGenerator(String name, Float price, String describe) {
		super();
		this.name = name;
		this.price = price;
		this.describe = describe;
	}

	public GoodsGenerator() {
		super();
	}
    
    
}