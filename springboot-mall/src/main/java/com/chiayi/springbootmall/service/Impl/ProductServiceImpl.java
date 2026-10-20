package com.chiayi.springbootmall.service.Impl;

import com.chiayi.springbootmall.dao.ProductDao;
import com.chiayi.springbootmall.model.Product;
import com.chiayi.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
