package com.mybatis.domain;

public class tag {
    private String tagName;
//    private String aticle;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
//
//    public String getAticle() {
//        return aticle;
//    }
//
//    public void setAticle(String aticle) {
//        this.aticle = aticle;
//    }


    @Override
    public String toString() {
        return "tag{" +
                "tagName='" + tagName + '\'' +
                '}';
    }
}
