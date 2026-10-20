package com.chiayi.springbootmall.dao;

import com.chiayi.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer id);
}
