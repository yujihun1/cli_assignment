package org.example;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {

    ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public int create(String subject, String content) {
        return articleRepository.create(subject, content);
    }


    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article getFindById(int id) {
        return articleRepository.getFindById(id);
    }
    public void remove(Article article) {
        articleRepository.remove(article);
    }
    public void update(Article article, String modifySubject, String modifyContent) {

        articleRepository.update(article,modifySubject,modifyContent);
    }
}
