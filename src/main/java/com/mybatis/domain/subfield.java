package com.mybatis.domain;

import java.util.Date;

public class subfield {
    private String sid;
    private String title;
    private  String desc;
    private  String logo;
    private Date date;
    private String bloger;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBloger() {
        return bloger;
    }

    public void setBloger(String bloger) {
        this.bloger = bloger;
    }

    @Override
    public String toString() {
        return "subfield{" +
                "sid='" + sid + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", logo='" + logo + '\'' +
                ", date=" + date +
                ", bloger='" + bloger + '\'' +
                '}';
    }
}
