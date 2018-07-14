package com.jing.news.grapnews.service;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public abstract class BaseService<T> {

    @Autowired
    private Mapper<T> mapper;

    public void add(T t){
        mapper.insert(t);
    }

    public Integer remove(T t){
        return mapper.delete(t);
    }

    public void update(T t) {
        mapper.updateByPrimaryKeySelective(t);
    }

    public T findById(Object ob) {
        return mapper.selectByPrimaryKey(ob);
    }

    public List<T> findByCondition(T t) {
        return mapper.select(t);
    }

    public List<T> selectAll(){
        return mapper.selectAll();
    }

}
