package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;

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
}
