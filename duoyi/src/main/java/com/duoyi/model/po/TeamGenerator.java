package com.duoyi.model.po;

import java.io.Serializable;

public class TeamGenerator implements Serializable {
    private Integer id;

    private Integer userId;

    private String name;

    private String describe;

    private String needSkill;

    private Integer result;

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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getNeedSkill() {
        return needSkill;
    }

    public void setNeedSkill(String needSkill) {
        this.needSkill = needSkill == null ? null : needSkill.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}