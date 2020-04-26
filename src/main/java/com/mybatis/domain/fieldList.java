package com.mybatis.domain;

public class fieldList {
    private String title;
    private String total;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "fieldList{" +
                "title='" + title + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
