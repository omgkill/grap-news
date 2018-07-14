package com.jing.news.grapnews.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {

    private final Logger log = LoggerFactory.getLogger(MyThread.class);

    @Value("${period:30}")
    private long period;

    private boolean flag = true;

    private String name;

    MyThread(String name){
        this.name = name;
    }


    @Override
    public void run() {
        while(flag) {
            log.info( name + "循环一次");
            try {
                Class<?> stance = Class.forName(name);
                Method method = stance.getMethod("getNews");
                Object obj = stance.newInstance();
                method.invoke(obj);

            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                    | InstantiationException  | InvocationTargetException e) {
                e.printStackTrace();
            }

            try {
                TimeUnit.SECONDS.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * flag 赋值
     * @param flag 关闭该线程的标志
     */
    public void setFlag(boolean flag){
        this.flag = flag;
    }
}
