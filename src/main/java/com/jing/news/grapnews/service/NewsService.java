package com.jing.news.grapnews.service;

import com.jing.news.grapnews.dao.NewsDao;
import com.jing.news.grapnews.domain.NewsBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsService {

    @Resource
    private NewsDao newsDao;

    /**
     *  添加新闻
     * @param bean 新闻实体对象
     */
    public void addNews(NewsBean bean){
        newsDao.insert(bean);
    }


    /**
     *  移除新闻
     *  @param bean 新闻对象
     *  @author jingShuai
     */
    @Transactional(readOnly = true)
    public void removeNews(NewsBean bean) {
        newsDao.delete(bean);
    }

    /**
     *  通过ID查询新闻
     *  @param id 新闻id
     *  @author jingShuai
     */
    @Transactional
    public NewsBean findNewsById(Integer id) {
        return newsDao.selectByPrimaryKey(id);
    }

    /**
     *  根据条件查询新闻
     *  @param bean 新闻实体类
     *  @author jingShuai
     */
    public List<NewsBean> findNewsBycondition(NewsBean bean){
        return newsDao.select(bean);
    }

    public List<NewsBean> findNewsByCategoryId(Integer id) {
        return newsDao.findNewsByCategoryId(id);
    }
}
