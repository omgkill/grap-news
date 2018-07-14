package com.jing.news.grapnews;

import com.jing.news.grapnews.service.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GrapNewsTest extends BaseTest{

    @Autowired
    private GrapNews grapNews;

    @Test
    public void getNews(){
      //  grapNews.getNews("xinche", 5);

    }
}