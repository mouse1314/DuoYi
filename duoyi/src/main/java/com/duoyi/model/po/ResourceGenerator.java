package com.duoyi.model.po;

import java.io.Serializable;
import java.util.Date;

public class ResourceGenerator implements Serializable {
    private Integer id;

    private Integer userId;

    private String url;

    private String describe;

    private Date time;

    private Integer price;

    private Integer number;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

	public ResourceGenerator() {
		super();
	}

	public ResourceGenerator(Integer userId, String url, String describe, Date time, Integer price,
			Integer number) {
		super();
		this.userId = userId;
		this.url = url;
		this.describe = describe;
		this.time = time;
		this.price = price;
		this.number = number;
	}
    
    
}