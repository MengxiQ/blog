package com.mybatis.dao;

import com.mybatis.domain.bloger;

public interface IblogerDao {
//    根据博主名查询博客主信息
    bloger findBlogerByName(String name);
}
