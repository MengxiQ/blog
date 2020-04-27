package com.mybatis.dao;

import com.mybatis.domain.tag;

import java.util.List;

public interface ItagDao {
    //根据分类拿到所有的tag
    List<tag> findTagBySubfield(String subField);

    //.根据uid拿到用户的所有tag
    List<tag> findTagByUid(String uid);
}
