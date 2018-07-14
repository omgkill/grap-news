package com.jing.news.grapnews.service;

import com.jing.news.grapnews.domain.CategoryBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceTest extends BaseTest {


    @Autowired
    private CategoryService categoryDao;

    @Test
    public void add() {
        CategoryBean bean = new CategoryBean();
        bean.setCategoryid(2);
        bean.setCategoryname("test");
        categoryDao.add(bean);
    }

    @Test
    public void remove() {
    }

    @Test
    public void update() {
    }

    @Test
    public void findById() {
        //   List<CategoryBean> bean = categoryDao.selectAll();
//        CategoryBean bean2 = new CategoryBean();
//        bean2.setCategoryid(244);
//        List<CategoryBean>  bean = categoryDao.findByCondition(bean2);
        CategoryBean bean = categoryDao.findById(3);

        if (bean != null) {
            System.out.println("---------------");
            // System.out.println(bean.size()+"|||||||||||||||");
            System.out.println(bean.toString());
        } else {
            System.out.println("++++++++++++++++");
            throw new NullPointerException();
        }
    }

    @Test
    public void findByCondition() {
    }



}