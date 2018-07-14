package com.jing.news.grapnews.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Set;

/**
 * 这个用了什么方法，一个是继承，策略模式
 *
 *
 */
public  class StartThread {

    private final Logger log = LoggerFactory.getLogger(StartThread.class);



    /**
     *  启动一个线程，每个新闻类型有一个类型
     * @param name 指定每个线程的名字
     */
    public static void start(String name){
        if(StringUtils.isEmpty(name)){
            return;
        }
        if( existThisThread(name) ) {
            return;
        }
        Thread t = new MyThread(name);
        t.setName(name);
        t.setDaemon(true);
        t.start();

    }

    /**
     *  验证是否该线程已启动
     *  @param
     *  @author jingShuai
     *  @return
     */
    private static boolean existThisThread(String name){
        Map<Thread, StackTraceElement[]> map=  Thread.getAllStackTraces();
        Set<Thread> set  = map.keySet();
        for(Thread t : set) {

            if(name.equals(t.getName())){
                return true;
            }
        }

        return false;
    }

    /**
     *  关闭该线程
     *  @param
     *  @author jingShuai
     *  @return
     */
    public static void close(String name){
        if(StringUtils.isEmpty(name)){
            return;
        }
        Map<Thread, StackTraceElement[]> map=  Thread.getAllStackTraces();
        Set<Thread> set  = map.keySet();
        for(Thread t : set) {

            if(name.equals(t.getName())){
                ((MyThread)t).setFlag(false);


            }
        }

    }

}
