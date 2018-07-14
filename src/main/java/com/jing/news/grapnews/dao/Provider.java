package com.jing.news.grapnews.dao;

public class Provider {

    public  String findNewsByCategoryId(Integer id){
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(" select n.* from news n, category c ");
        sb.append(" where n.categoryid = c.categoryid and ");
        sb.append(" c.categoryid = " );
        sb.append(id);
        return sb.toString();
    }
}
