package org.example;

public class Article {
    int id;
    String subject;
    String content;

    Article(int id,String subject,String content){
        this.id=id;
        this.subject=subject;
        this.content=content;
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
}
