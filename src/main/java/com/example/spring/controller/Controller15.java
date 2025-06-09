package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.ProductsDTO;
import com.example.spring.dto.SuppliersDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main15")
public class Controller15 {
    // paging

    @RequestMapping("sub1")
    public String sub1(@RequestParam(defaultValue = "1") Integer page, Model model) throws Exception {

        // 1페이지에 10개씩 출력
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        // 총 고객수
        String countSql = """
                SELECT COUNT(*) count
                FROM Customers
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        // offset : (Page - 1) * (페이지 당 개수)
//        statement.setInt(1, 0);     // 1page
//        statement.setInt(1, 10);     // 2page
//        statement.setInt(1, 20);     // 3page
        int offset = (page - 1) * 10;
        statement.setInt(1, offset);     // 페이지 별 시작 번호
        statement.setInt(2, 10);    // 페이지 당 개수

        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count");    // 총 고객수
        int lastPage = (count - 1) / 10 + 1;
        model.addAttribute("lastPage", lastPage);

        ResultSet rs = statement.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs.getInt("customerId"));
            customerDto.setName(rs.getString("customerName"));
            customerDto.setContactName(rs.getString("contactName"));
            customerDto.setAddress(rs.getString("address"));
            customerDto.setCity(rs.getString("city"));
            customerDto.setPostalCode(rs.getString("postalCode"));
            customerDto.setCountry(rs.getString("country"));
            list.add(customerDto);
        }
        model.addAttribute("customerList", list);

        return "main15/sub1";
    }

    // 페이지당 5개의 공급자가 출력되도록 (정렬은 공급자 번호 순)
    @RequestMapping("sub2")
    public String sub2(@RequestParam(defaultValue = "1") Integer page, Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Suppliers
                ORDER BY SupplierID
                LIMIT ?, ?
                """;
        String countSql = """
                SELECT COUNT(*) count
                FROM Suppliers
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        int offset = (page - 1) * 5;
        statement.setInt(1, offset);
        statement.setInt(2, 5);

        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count");
        int lastPage = (count - 1) / 5 + 1;
        model.addAttribute("lastPage", lastPage);

        ResultSet rs = statement.executeQuery();
        List<SuppliersDTO> list = new ArrayList<>();
        while (rs.next()) {
            SuppliersDTO supplierDto = new SuppliersDTO();
            supplierDto.setId(rs.getInt("supplierId"));
            supplierDto.setName(rs.getString("supplierName"));
            supplierDto.setContactName(rs.getString("contactName"));
            supplierDto.setAddress(rs.getString("address"));
            supplierDto.setCity(rs.getString("city"));
            supplierDto.setPostalCode(rs.getString("postalCode"));
            supplierDto.setCountry(rs.getString("country"));
            supplierDto.setPhone(rs.getString("phone"));
            list.add(supplierDto);
        }
        model.addAttribute("supplierList", list);

        return "main15/sub2";
    }

    // paging + 검색
    @GetMapping("sub3")
    public String sub3(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "") String keyword,
                       Model model) throws Exception {

        String countSql = """
                SELECT COUNT(*) count
                FROM Customers
                WHERE CustomerName LIKE ?
                OR ContactName LIKE ?
                """;
        String sql = """
                SELECT *
                FROM Customers
                WHERE CustomerName LIKE ?
                OR ContactName LIKE ?
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement countStmt = connection.prepareStatement(countSql);
        countStmt.setString(1, "%" + keyword + "%");
        countStmt.setString(2, "%" + keyword + "%");
        PreparedStatement selectStmt = connection.prepareStatement(sql);
        selectStmt.setString(1, "%" + keyword + "%");
        selectStmt.setString(2, "%" + keyword + "%");

        Integer offset = (page - 1) * 5;
        selectStmt.setInt(3, offset);
        selectStmt.setInt(4, 5);

        ResultSet rs1 = countStmt.executeQuery();
        rs1.next();
        int count = rs1.getInt("count");
        int lastPage = (count - 1) / 5 + 1;
        model.addAttribute("lastPage", lastPage);

        int rightPage = ((page - 1) / 10 + 1) * 10;
        int leftPage = rightPage - 9;
        int prevPage = leftPage - 10;
        int nextPage = rightPage + 1;
        rightPage = Math.min(rightPage, lastPage);  // rightPage는 lastPage보다 클 수 없다.
        model.addAttribute("rightPage", rightPage);
        model.addAttribute("leftPage", leftPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);

        ResultSet rs2 = selectStmt.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs2.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs2.getInt("customerId"));
            customerDto.setName(rs2.getString("customerName"));
            customerDto.setContactName(rs2.getString("contactName"));
            customerDto.setAddress(rs2.getString("address"));
            customerDto.setCity(rs2.getString("city"));
            customerDto.setPostalCode(rs2.getString("postalCode"));
            customerDto.setCountry(rs2.getString("country"));
            list.add(customerDto);
        }
        model.addAttribute("customerList", list);

        return "main15/sub3";
    }

    @GetMapping("sub4")
    public String sub4(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "") String keyword,
                       Model model) throws Exception {

        String countSql = """
                SELECT COUNT(*) count
                FROM Products
                WHERE ProductName LIKE ?
                """;
        String sql = """
                SELECT *
                FROM Products
                WHERE ProductName LIKE ?
                ORDER BY ProductID
                LIMIT ?, ?
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        PreparedStatement countStmt = connection.prepareStatement(countSql);
        countStmt.setString(1, "%" + keyword + "%");

        PreparedStatement selectStmt = connection.prepareStatement(sql);
        selectStmt.setString(1, "%" + keyword + "%");
        Integer offset = (page - 1) * 5;
        selectStmt.setInt(2, offset);
        selectStmt.setInt(3, 5);

        ResultSet rs1 = countStmt.executeQuery();
        rs1.next();
        int count = rs1.getInt("count");
        int lastPage = (count - 1) / 5 + 1;
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("total", count);

        int rightPage = ((page - 1) / 10 + 1) * 10;
        int leftPage = rightPage - 9;
        int prevPage = leftPage - 10;
        int nextPage = rightPage + 1;
        rightPage = Math.min(rightPage, lastPage);  // rightPage는 lastPage보다 클 수 없다.
        model.addAttribute("rightPage", rightPage);
        model.addAttribute("leftPage", leftPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);

        ResultSet rs2 = selectStmt.executeQuery();
        List<ProductsDTO> list = new ArrayList<>();
        while (rs2.next()) {
            ProductsDTO productsDTO = new ProductsDTO();
            productsDTO.setId(rs2.getInt("productId"));
            productsDTO.setName(rs2.getString("productName"));
            productsDTO.setSupplier(rs2.getInt("supplierId"));
            productsDTO.setCategory(rs2.getInt("categoryId"));
            productsDTO.setUnit(rs2.getString("unit"));
            productsDTO.setPrice(rs2.getDouble("price"));
            list.add(productsDTO);
        }
        model.addAttribute("productList", list);

        return "main15/sub4";
    }

}
