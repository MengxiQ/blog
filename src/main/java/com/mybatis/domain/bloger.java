package com.mybatis.domain;

import java.util.Date;

public class bloger {
    private String uid;
    private String name;
    private Date birthday;
    private String signatrue;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSignatrue() {
        return signatrue;
    }

    public void setSignatrue(String signatrue) {
        this.signatrue = signatrue;
    }

    @Override
    public String toString() {
        return "bloger{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", signatrue='" + signatrue + '\'' +
                '}';
    }
}
