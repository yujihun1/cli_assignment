package org.example;


import org.example.db.DBConnection;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class App {

    ArticleController articleController;
    SystemController systemController;
    App() {
        DBConnection.DB_NAME="proj1";
        DBConnection.DB_PORT=3306;
        DBConnection.DB_USER="root";
        DBConnection.DB_PASSWORD="";

       //DBConnection dbConnection = new DBConnection();
      // dbConnection.connect();

        //List<Map<String, Object>> rs = dbConnection.selectRows("select * from article");
        //System.out.println(rs);

        Container.getDBConnection().connect();


        articleController = new ArticleController();
        systemController = new SystemController();
    }

    public void run() {
        System.out.println("==게시판 앱==");



        while (true) {
            System.out.print("명령)");
            String command = Container.getSc().nextLine().trim();
            Request request = new Request(command);
            if (request.getActionCode().equals("종료")) {
                systemController.exit();
                break;
            } else if (request.getActionCode().equals("등록")) {
               articleController.write();
            } else if (request.getActionCode().equals("목록")) {
               articleController.list();
            } else if (request.getActionCode().startsWith("삭제")) {
               articleController.delete(request);
            } else if (request.getActionCode().startsWith("수정")) {
                articleController.modify(request);
            }
        }

    }

}



