package com.example.product.service;


import com.example.product.form.ProductForm;
import com.example.product.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();

    Product addNewProduct(Product product);

    Product getProductById(Integer id);

    Product getProductByName(String name);

    void deleteProductById(Integer id);

    Product updateProduct(Integer id, String new_name, String new_brand, int new_price);
}
