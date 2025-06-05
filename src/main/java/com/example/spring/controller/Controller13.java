package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main13")
public class Controller13 {
    @GetMapping("sub1")
    public String sub1(Model model) throws Exception {
        // 1. request 분석/가공
        //      @GetMapping, @PostMapping, @RequestParam
        // 2. request 처리 (business logic)
        //      CRUD (Create/Read/Update/Delete)
        //  2.1 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        //  2.2 쿼리(sql) 실행
        String sql = """
                SELECT CustomerName
                FROM Customers
                WHERE CustomerID = 1
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        //  2.3 결과 처리
        String name = "";
        if (resultSet.next()) {
            name = resultSet.getString("CustomerName");
        }
        // 3. 결과를 Model(or RedirectAttribute)에 담고
        //      model.addAttribute(), rttr.addFlashAttribute(), rttr.addAttribute()
        //      session.setAttribute()
        model.addAttribute("name", name);
        // 4. view로 forwarding
        //      다른 경로로 redirection

        return "main13/sub1";
    }

    @GetMapping("sub2")
    public String sub2(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = """
                SELECT ProductName
                FROM Products
                WHERE ProductID = 1
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        String name = "";
        if (resultSet.next()) {
            name = resultSet.getString("ProductName");
        }
        model.addAttribute("name", name);

        return "main13/sub2";
    }

    @GetMapping("sub3")
    public String sub3(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT LastName
                FROM Employees
                """;

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        // ResultSet :
        // table 형태의 결과
        // 내부에 행(row)를 가리키는 커서가 있다.
        // next() 호출하면 다음 행으로 커서 이동
        // get...() : 컬럼 값을 얻는 메소드

        resultSet.next();   // 1번째 행 가리킴    = true 반환
        String name1 = resultSet.getString("LastName");
        resultSet.next();   // 2번째 행 가리킴
        String name2 = resultSet.getString("LastName");
        resultSet.next();   // 3번째 행 가리킴
        String name3 = resultSet.getString("LastName");
        resultSet.next();   // 4번째 행 가리킴
        String name4 = resultSet.getString("LastName");
        resultSet.next();   // 5번째 행 가리킴
        String name5 = resultSet.getString("LastName");
        resultSet.next();   // 6번째 행 가리킴
        String name6 = resultSet.getString("LastName");
        resultSet.next();   // 7번째 행 가리킴
        String name7 = resultSet.getString("LastName");
        resultSet.next();   // 8번째 행 가리킴
        String name8 = resultSet.getString("LastName");
        resultSet.next();   // 9번째 행 가리킴    = true 반환
        String name9 = resultSet.getString("LastName");
        resultSet.next();   // 10번째 행 가리킴   = data가 없으므로 false 반환

        var list = List.of(name1, name2, name3, name4, name5, name6, name7, name8, name9);
        model.addAttribute("nameList", list);

        return "main13/sub3";
    }

    @GetMapping("sub4")
    public String sub4(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT FirstName
                FROM Employees
                """;

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        // ResultSet :
        // table 형태의 결과
        // 내부에 행(row)를 가리키는 커서가 있다.
        // next() 호출하면 다음 행으로 커서 이동
        // get...() : 컬럼 값을 얻는 메소드

        var list = new ArrayList<String>();
        while (resultSet.next()) {
            String name = resultSet.getString("FirstName");
            list.add(name);
        }
        model.addAttribute("nameList", list);

        return "main13/sub3";
    }

}
