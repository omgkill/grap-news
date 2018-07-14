package com.jing.news.grapnews.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="comment")
public class CommentBean {
    @Id
    int id;

    String commentcontent;
    String commenttime;
    int commentuserid;
    int commentnewsid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime;
    }

    public int getCommentuserid() {
        return commentuserid;
    }

    public void setCommentuserid(int commentuserid) {
        this.commentuserid = commentuserid;
    }

    public int getCommentnewsid() {
        return commentnewsid;
    }

    public void setCommentnewsid(int commentnewsid) {
        this.commentnewsid = commentnewsid;
    }

}
