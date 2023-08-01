package com.product.dao;

import java.util.List;
import com.product.model.Review;

public interface ReviewDao {
    void create(Review review);
    List<Review> getReviewsForProduct(int productId);
}
