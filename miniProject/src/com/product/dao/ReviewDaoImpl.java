package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.model.Review;
import com.product.util.DBHandler;

public class ReviewDaoImpl implements ReviewDao {

    @Override
    public void create(Review review) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBHandler.getConnection();
            String query = "INSERT INTO reviews (productId, customerName, rating, comment) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, review.getProductId());
            ps.setString(2, review.getCustomerName());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getComment());

            ps.executeUpdate();
            System.out.println("Review added successfully!");
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
    public List<Review> getReviewsForProduct(int productId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Review> reviews = new ArrayList<>();

        try {
            conn = DBHandler.getConnection();
            String query = "SELECT * FROM reviews WHERE productId = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);

            rs = ps.executeQuery();

            while (rs.next()) {
                Review review = new Review();
                review.setReviewId(rs.getInt("reviewId"));
                review.setProductId(rs.getInt("productId"));
                review.setCustomerName(rs.getString("customerName"));
                review.setRating(rs.getInt("rating"));
                review.setComment(rs.getString("comment"));
                reviews.add(review);
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

        return reviews;
    }
}
