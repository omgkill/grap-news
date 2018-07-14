package com.jing.news.grapnews.service;

import com.jing.news.grapnews.dao.NewsDao;
import com.jing.news.grapnews.domain.NewsBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsServiceTest {

    private Logger log = LoggerFactory.getLogger(NewsService.class);

    @Autowired
    private NewsService newsService;

    @Resource
    private NewsDao newsDao;

    @Test
    public void addNews() {

    }

    @Test
    public void removeNews() {
        NewsBean bean = new NewsBean();
        bean.setId(99);
        newsService.removeNews(bean);
    }

    @Test
    public void findNewsById() {
//        NewsBean bean = newsService.findNewsById(49);
////        log.info(bean.toString());
        NewsBean bean = newsDao.findNewsByidWithCategory(23);
        if(bean == null) {
            log.info("kong");
        } else {
            log.info(bean.toString());
        }

    }

    @Test
    public void findNewsBycondition() {
        NewsBean newsBean = new NewsBean();
        newsBean.setId(99);
    }

    @Test
    public void findNewsByCategoryId(){
        List<NewsBean> list = newsService.findNewsByCategoryId(2);
        log.info(list.toString());
    }
}