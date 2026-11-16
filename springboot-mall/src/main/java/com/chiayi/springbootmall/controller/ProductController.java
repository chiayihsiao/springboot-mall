package com.chiayi.springbootmall.controller;

import com.chiayi.springbootmall.constant.ProductCategory;
import com.chiayi.springbootmall.dto.ProductQueryParams;
import com.chiayi.springbootmall.dto.ProductRequest;
import com.chiayi.springbootmall.model.Product;
import com.chiayi.springbootmall.service.ProductService;
import com.chiayi.springbootmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public  ResponseEntity<Page<Product>> getProduct(
            //查詢條件 Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            //排序 Sorting(設定好預設值)
            @RequestParam(defaultValue = "created_date") String orderBy,//4-7
            @RequestParam(defaultValue = "desc") String sort,

            //分頁 Pagination
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer  limit,//取得幾筆數據
            @RequestParam(defaultValue = "0") @Min(0) Integer offset//跳過幾筆數據
    ) {
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        //取得productList
        List<Product>productList = productService.getProducts(productQueryParams);

        //取得product 總數
        Integer total = productService.countProcduct(productQueryParams);

        //分頁
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        if(product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product>createProcduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updarProduct(@PathVariable Integer productId,
                                                @RequestBody @Valid ProductRequest productRequest) {


        //檢查product是否存在
        Product product = productService.getProductById(productId);
        if(product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //修改商品的數據
        productService.updateProduct(productId,productRequest);
            Product updatedProduct = productService.getProductById(productId);
            return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

      @DeleteMapping("/products/{productId}")
      public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
            productService.deleteProductById(productId);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();//204

      }
}
