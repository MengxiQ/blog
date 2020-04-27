package com.servies.domain;

import com.mybatis.domain.aticle;
import com.mybatis.domain.subfield;

import java.util.List;

public class subfieldData {
    private subfield intro;
    private List<String> tags;
    private List<aticle> aticles;

    public subfield getIntro() {
        return intro;
    }

    public void setIntro(subfield intro) {
        this.intro = intro;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<aticle> getAticles() {
        return aticles;
    }

    public void setAticles(List<aticle> aticles) {
        this.aticles = aticles;
    }

    @Override
    public String toString() {
        return "subfieldData{" +
                "intro=" + intro +
                ", tags=" + tags +
                ", aticles=" + aticles +
                '}';
    }
}
