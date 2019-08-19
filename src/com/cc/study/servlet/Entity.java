package com.cc.study.servlet;

/**
 * web.xml -> <servlet>解析对象
 *
 * @author chenc
 * @create 2019-08-18 16:04
 **/
public class Entity {
    private String name;
    private String clazzs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazzs() {
        return clazzs;
    }

    public void setClazzs(String clazzs) {
        this.clazzs = clazzs;
    }

    public Entity() {
    }

}
