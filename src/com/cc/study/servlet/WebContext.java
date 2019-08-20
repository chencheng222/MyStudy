package com.cc.study.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 处理上下文
 * 目的：将xml解析出来的对象转换成Map的形式，便于存取
 *
 * @author chenc
 * @create 2019-08-20 21:48
 **/
public class WebContext {
    private List<Entity> entities;
    private List<Mapping> mappings;

    // k->servlet-name v->servlet-class
    private Map<String, String> entityMap = new HashMap<String, String>();
    // k->url-pattern v->servlet-name
    private Map<String, String> mappingMap = new HashMap<String, String>();

    public WebContext(List<Entity> entities, List<Mapping> mappings) {
        this.entities = entities;
        this.mappings = mappings;

        for (Entity entity : entities) {
            entityMap.put(entity.getName(), entity.getClazzs());
        }

        for (Mapping mapping : mappings) {
            Set<String> patterns = mapping.getPatterns();
            for (String pattern : patterns) {
                mappingMap.put(pattern, mapping.getName());
            }
        }

    }



    public String getClazz(String pattern) {
        String servletName = mappingMap.get(pattern);
        return entityMap.get(servletName);
    }
}
