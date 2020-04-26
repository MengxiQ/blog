package com.mybatis.domain;

public class blog {
    private String blogid;
    private String name;
    private String desc;
    private String logo;
    private String bloger;

    public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBloger() {
        return bloger;
    }

    public void setBloger(String bloger) {
        this.bloger = bloger;
    }

    @Override
    public String toString() {
        return "blog{" +
                "blogid='" + blogid + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", logo='" + logo + '\'' +
                ", bloger='" + bloger + '\'' +
                '}';
    }
}
