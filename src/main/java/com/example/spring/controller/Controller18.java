package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main18")
public class Controller18 {

    //*    데이터 조회
    @GetMapping("sub1")
    public String sub1(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM table53
                """;

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Map<String, Object>> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            map.put("user", resultSet.getString("user"));
            map.put("money", resultSet.getInt("money"));
            list.add(map);
        }

        model.addAttribute("list", list);

        return "main18/sub1";
    }

    //* update query 2개 실행 (auto-commit)
    @PostMapping("sub2")
    public String success1(Model model) throws Exception {
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql1);
        statement.executeUpdate();
        PreparedStatement statement1 = connection.prepareStatement(sql2);
        statement1.executeUpdate();

        return "redirect:/main18/sub1";

    }

    //* update query 1개 auto-commit 이후 Fail (Exception)
    @PostMapping("sub3")
    public String fail1(Model model) throws Exception {
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql1);
        statement.executeUpdate();

        if (true) {
            throw new Exception("네트워크 연결 끊어짐");
        }

        PreparedStatement statement1 = connection.prepareStatement(sql2);
        statement1.executeUpdate();

        return "redirect:/main18/sub1";

    }

    //* auto-commit:false 설정, update query 2개 실행 후, connection.commit();
    @PostMapping("sub4")
    public String success2(Model model) throws Exception {
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
        PreparedStatement statement = connection.prepareStatement(sql1);
        statement.executeUpdate();

        PreparedStatement statement1 = connection.prepareStatement(sql2);
        statement1.executeUpdate();

        connection.commit();

        return "redirect:/main18/sub1";

    }

    //* auto-commit:false 설정, update query 1개 실행 후, throws Exception, connection.rollback();
    @PostMapping("sub5")
    public String fail2(Model model) {
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            try (connection) {
                connection.setAutoCommit(false);
                try {
                    PreparedStatement statement = connection.prepareStatement(sql1);
                    PreparedStatement statement1 = connection.prepareStatement(sql2);

                    try (statement1; statement) {
                        statement.executeUpdate();

                        if (true) {
                            throw new Exception("네트워크 오류!!");
                        }

                        statement1.executeUpdate();
                    }
                    connection.commit();
                } catch (Exception e) {
                    connection.rollback();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "redirect:/main18/sub1";

    }

    @GetMapping("sub6")
    public String sub6(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM table53
                """;

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Map<String, Object>> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            map.put("user", resultSet.getString("user"));
            map.put("money", resultSet.getInt("money"));
            list.add(map);
        }

        model.addAttribute("list", list);

        return "main18/sub6";
    }

    @PostMapping("sub7")
    public String sub7(Model model, RedirectAttributes rttr) throws Exception {
        // b->a (500원)
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;

        // db
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";

//        try {
        Connection connection = DriverManager.getConnection(url, username, password);

//            try (connection) {
                connection.setAutoCommit(false);
                try {
                    PreparedStatement statement = connection.prepareStatement(sql1);
                    PreparedStatement statement1 = connection.prepareStatement(sql2);

//                    try (statement1; statement) {
                        // b의 돈 500 차감
                        // update1 exec
                        statement.executeUpdate();

                        double random = Math.random();

                        // 50% 확률로 성공or실패 -> 실패시 rollback, 성공시 commit
                        if (random < 0.5) {
                            // 50% 확률로 Exception
                            throw new Exception("네트워크 오류");
                        }

                        // a의 돈 500 증가
                        // update2 exec
                        statement1.executeUpdate();
//                    }
                    connection.commit();
//                    System.out.println("성공");
                    rttr.addFlashAttribute("message", "송금 성공");

                } catch (Exception e) {
                    connection.rollback();
//                    System.out.println("실패");
                    rttr.addFlashAttribute("message", "송금 실패");

                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return "redirect:/main18/sub6";
    }
}
