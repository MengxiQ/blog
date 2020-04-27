package com.mybatis.domain;

import java.util.Date;

public class aticle {
    private String aid;
    private String src;
    private String title;
    private Date date;
    private String logo;
    private String recommend;
    private String subfield;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getSubfield() {
        return subfield;
    }

    public void setSubfield(String subfield) {
        this.subfield = subfield;
    }

    @Override
    public String toString() {
        return "{" +
                "\"aid\":\"" + aid + '\"' +
                ",\"src\":\"" + src + '\"' +
                ",\"title\":\"" + title + '\"' +
                ",\"date\":\"" + date + '\"' +
                ",\"logo=\":\"" + logo + '\"' +
                ",\" recommend\":\"" + recommend + '\"' +
                ",\"subfield\":\"" + subfield + '\"' +
                '}';
    }
}
