package com.jing.news.grapnews.dao;

import com.jing.news.grapnews.domain.NewsBean;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NewsDao extends Mapper<NewsBean> {

    @Select("select n.* from news n, category c where n.categoryid = c.categoryid and n.id = #{id}" )
     NewsBean findNewsByidWithCategory(@Param("id") Integer id);

    @SelectProvider(type =Provider.class, method = "findNewsByCategoryId")
//    @Results({
//            @Result(property = "aaaaid", column = "categoryid")
//    })
    List<NewsBean> findNewsByCategoryId(Integer id);
}
