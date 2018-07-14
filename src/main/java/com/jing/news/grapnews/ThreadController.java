package com.jing.news.grapnews;


import com.jing.news.grapnews.thread.StartThread;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadController {


    @GetMapping("/start")
    public void startThread(String name){
        name = "com.jing.news.grapnews.grap.TechNews";
        StartThread.start(name);
    }

    @GetMapping("/stop")
    public void stopThread(String name){
        name = "com.jing.news.grapnews.grap.TechNews";
        StartThread.close(name);
    }

}
