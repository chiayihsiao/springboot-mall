package com.chiayi.springbootmall.dao;

import com.chiayi.springbootmall.dto.ProductRequest;
import com.chiayi.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
}
