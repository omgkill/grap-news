package com.jing.news.grapnews.domain;

import com.alibaba.fastjson.JSONObject;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "news")
public class NewsBean {
    @Id
    @KeySql(useGeneratedKeys = true)
	private Integer id;
	private String title;
	private Timestamp time;
	private String content;
	private String keywords;
	@Column(name = "categoryid")
	private Integer categoryId;
    @Column(name = "pictureaddress")
	private String pictureAddress;
    @Column(name = "videoaddress")
	private String videoAddress;
	@Column(name = "authorname")
	private String authorName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
