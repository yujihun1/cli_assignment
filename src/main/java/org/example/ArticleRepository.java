package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {
    List<Article> articleList = new ArrayList<>();


    public int create(String subject, String content) {
        String sql = String.format("insert into article set subject='%s', content='%s'", subject, content);
        int id = Container.getDBConnection().insert(sql);
        return id;
    }


    public List<Article> findAll() {
        List<Article> articleList = new ArrayList<>();

        List<Map<String,Object>> rows =
                Container.getDBConnection().selectRows("select * from article");

        for(Map<String,Object> row : rows) {
            Article article = new Article(row);
            articleList.add(article);
        }
        return articleList;
    }

    public Article findById(int id) {
        List<Article> articleList = this.findAll();
        for(Article item: articleList) {
            if(item.getId()==id){
                return item;
            }
        }
        return null;
    }

    public void remove(Article article) {
        String sql = String.format("DELETE FROM article where id = %d", article.getId());
        Container.getDBConnection().delete(sql);
    }

    public void modify(Article article, String modifySubject, String modifyContent) {
        String sql = String.format("UPDATE article SET subject='%s', content='%s' where id = %d", modifySubject, modifyContent, article.getId());
        Container.getDBConnection().modify(sql);

    }
}
