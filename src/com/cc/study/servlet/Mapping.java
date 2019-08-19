package com.cc.study.servlet;

import java.util.HashSet;
import java.util.Set;

/**
 * web.xml -> <servlet-mapping>解析对象
 *
 * @author chenc
 * @create 2019-08-18 16:14
 **/
public class Mapping {
    private String name;
    private Set<String> patterns;

    public Mapping() {
        patterns = new HashSet<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<String> patterns) {
        this.patterns = patterns;
    }

    public void add(String pattern) {
        this.patterns.add(pattern);
    }
}
