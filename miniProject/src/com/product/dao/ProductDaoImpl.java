package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.model.Product;
import com.product.util.DBHandler;

public class ProductDaoImpl implements ProductDao {

    @Override
    public void create(Product product) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBHandler.getConnection();
            String query = "INSERT INTO products (name, description) VALUES (?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());

            ps.executeUpdate();
            System.out.println("Product added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Product> getAllProducts() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<>();

        try {
            conn = DBHandler.getConnection();
            String query = "SELECT * FROM products";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }
}
