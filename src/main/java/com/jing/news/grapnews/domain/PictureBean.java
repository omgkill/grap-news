package com.jing.news.grapnews.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "picture")
public class PictureBean {
    @Id
    private int pictureid;
    private String pictureadress;

    public int getPictureid() {
        return pictureid;
    }

    public void setPictureid(int pictureid) {
        this.pictureid = pictureid;
    }

    public String getPictureadress() {
        return pictureadress;
    }

    public void setPictureadress(String pictureadress) {
        this.pictureadress = pictureadress;
    }

}
