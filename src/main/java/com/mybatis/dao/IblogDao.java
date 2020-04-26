package com.mybatis.dao;

import com.mybatis.domain.blog;

public interface IblogDao {
    blog findBlogByUid(String Uid);
}
