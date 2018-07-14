package com.jing.news.grapnews.grap;

import java.util.concurrent.TimeUnit;

public class TechNews {
    public void getNews(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
