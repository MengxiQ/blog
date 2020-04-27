package com.servies.domain;

import com.mybatis.domain.*;
import com.mybatis.domain.bloger;

import java.util.List;

public class homeData {
    private blog blog;
    private bloger bloger;
    private List<aticle> aticles;
    private List<fieldList> fieldList;
    private List<aticle> recommend;
    private List<String> allTag;

    public com.mybatis.domain.blog getBlog() {
        return blog;
    }

    public void setBlog(com.mybatis.domain.blog blog) {
        this.blog = blog;
    }

    public com.mybatis.domain.bloger getBloger() {
        return bloger;
    }

    public void setBloger(com.mybatis.domain.bloger bloger) {
        this.bloger = bloger;
    }

    public List<com.mybatis.domain.fieldList> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<com.mybatis.domain.fieldList> fieldList) {
        this.fieldList = fieldList;
    }

    public List<aticle> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<aticle> recommend) {
        this.recommend = recommend;
    }

    public List<String> getAllTag() {
        return allTag;
    }

    public void setAllTag(List<String> allTag) {
        this.allTag = allTag;
    }

    public List<aticle> getAticles() {
        return aticles;
    }

    public void setAticles(List<aticle> aticles) {
        this.aticles = aticles;
    }

    @Override
    public String toString() {
        return "homedata{" +
                "blog=" + blog +
                ", bloger=" + bloger +
                ", aticles=" + aticles +
                ", fieldList=" + fieldList +
                ", recommend=" + recommend +
                ", allTag=" + allTag +
                '}';
    }
}
