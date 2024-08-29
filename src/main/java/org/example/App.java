package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner sc;
    App(Scanner sc){
        this.sc=sc;
    }
    public void run(){
        System.out.println("==게시판 앱==");
        int lastId = 1;
        ArrayList<Article> articleList = new ArrayList<>();

        while (true) {
            System.out.print("명령)");
            String command = sc.nextLine().trim();
            if (command.equals("종료")) {
                System.out.println("종료됩니다.");
                break;
            }else if(command.equals("등록")){
                System.out.print("제목 :");
                String subject = sc.nextLine().trim();
                System.out.print("내용 :");
                String content = sc.nextLine().trim();
                System.out.printf("%d번 게시물이 등록되었습니다\n",lastId);
                Article article = new Article(lastId,subject,content);
                articleList.add(article);

                lastId++;
            }else if(command.equals("목록")){
                System.out.println("번호 / 제목 / 내용");
                System.out.println("----------------------");
                for(int i=0; i<articleList.size(); i++){
                    Article article = articleList.get(i);
                    System.out.printf("%d / %s / %s\n", article.getId(), article.getSubject(), article.getContent());
                }

            }
        }
    }
}
