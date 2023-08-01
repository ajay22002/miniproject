package com.product.dao;

import java.util.List;
import com.product.model.Product;

public interface ProductDao {
    void create(Product product);
    List<Product> getAllProducts();
}
