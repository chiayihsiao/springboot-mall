package com.chiayi.springbootmall.service;

import com.chiayi.springbootmall.constant.ProductCategory;
import com.chiayi.springbootmall.dto.ProductRequest;
import com.chiayi.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category,String search);


    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
