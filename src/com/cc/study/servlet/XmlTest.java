package com.cc.study.servlet;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * sax解析xml流程
 *
 * @author chenc
 * @create 2019-08-18 16:18
 **/
public class XmlTest {
    public static void main(String[] args) throws Exception {
        //SAX解析
        //1、获取解析工厂
        SAXParserFactory factory=SAXParserFactory.newInstance();
        //2、从解析工厂获取解析器
        SAXParser parse =factory.newSAXParser();
        //3、编写处理器
        //4、加载文档 Document 注册处理器
        WebHandle handler=new WebHandle();
        //5、解析
        parse.parse(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("com/cc/study/servlet/web.xml")
                ,handler);
    }
}

class WebHandle extends DefaultHandler {
    private List<Entity> entities;
    private List<Mapping> mappings;
    private Entity entity;
    private Mapping mapping;
    // 存储操作标签
    private String tag;
    private boolean isMapping = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("----解析文档开始----");
        entities = new ArrayList<Entity>();
        mappings = new ArrayList<Mapping>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName+"-->解析开始");
        if (StringUtils.isEmpty(qName)) {
            return;
        }

        tag = qName;

        if ("servlet".equals(tag)) {
            entity = new Entity();
            isMapping = false;
        } else if ("servlet-mapping".equals(tag)) {
            mapping = new Mapping();
            isMapping = true;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch,start,length).trim();

        if (StringUtils.isEmpty(tag)) {
            return;
        }

        if (isMapping) {
            if ("servlet-name".equals(tag)) {
                entity.setName(contents);
            } else if ("servlet-class".equals(tag)) {
                entity.setClazzs(contents);
            }
        } else {
            if ("servlet-name".equals(tag)) {
                mapping.setName(contents);
            } else if ("url-pattern".equals(tag)) {
                mapping.add(contents);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName+"-->解析结束");
        if (StringUtils.isEmpty(qName)) {
            return;
        }

        if ("servlet".equals(tag)) {
            entities.add(entity);
        } else if ("servlet-mapping".equals(tag)) {
            mappings.add(mapping);
        }

        tag = null;
    }
    @Override
    public void endDocument() throws SAXException {
        System.out.println("----解析文档结束----");
    }
}
