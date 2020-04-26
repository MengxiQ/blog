package com.mybatis.dao;

import com.mybatis.domain.aticle;

import java.util.List;

public interface IaticleDao {
    //根据页码查询所有文章
    List<aticle> findAticlesByPage(int page);
    //查询文章的总数
    int findTotal();
    //查询推荐文章
    List<aticle> findReacommendAticles();
    //.根据tagName拿到文章
    List<aticle> findAticlesByTag(String tag);
}
