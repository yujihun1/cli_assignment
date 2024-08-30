package org.example;

import java.util.Map;

public class Article {
    int id;
    String subject;
    String content;

    Article(int id,String subject,String content){
        this.id=id;
        this.subject=subject;
        this.content=content;
    }

    Article(Map<String,Object>row){
        this.id=(int)row.get("id");
        this.subject=(String)row.get("subject");
        this.content=(String)row.get("content");
    }

     int getId() {
        return this.id;
    }

    String getSubject() {
        return this.subject;
    }

    String getContent() {
        return this.content;
    }

    public void setSubject(String subject) {
        this.subject=subject;
    }

    public void setContent(String content) {
        this.content=content;
    }

    public void modify(Article article, String modifySubject, String modifyContent) {
        article.setSubject(modifySubject);
        article.setContent(modifyContent);
    }
}
