package com.chiayi.springbootmall.service;

import com.chiayi.springbootmall.dto.ProductRequest;
import com.chiayi.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
