package com.duoyi.model.po;

import java.io.Serializable;

public class PhotoGenerator implements Serializable {
	private Integer id;

    private Integer cardId;

    private Integer goodId;

    private String img;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.img = img == null ? null : img.trim();
    }
    public PhotoGenerator(Integer goodId, String img) {
		super();
		this.goodId = goodId;
		this.img = img;
	}

	public PhotoGenerator() {
		super();
	}

    
}