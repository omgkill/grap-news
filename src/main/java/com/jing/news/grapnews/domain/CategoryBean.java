package com.jing.news.grapnews.domain;

import com.alibaba.fastjson.JSONObject;

import javax.persistence.Id;
import javax.persistence.Table;

//lei
@Table(name = "category")
public class CategoryBean {
    @Id
	private Integer categoryid;
	private String categoryname;

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }

}
