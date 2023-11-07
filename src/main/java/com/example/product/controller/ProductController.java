package com.example.product.controller;


import com.example.product.dto.ProductDto;
import com.example.product.form.ProductForm;
import com.example.product.models.Product;
import com.example.product.response.APIResponse;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<APIResponse> addProduct(@RequestBody Product new_product) {
        productService.addNewProduct(new_product);
        ProductDto productDto = new_product.toDto();
        APIResponse apiResponse = APIResponse.success(productDto, HttpStatus.OK.value(), "Them san pham thanh cong: ");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<APIResponse> getProductList(){
        List<Product> productList = productService.getProductList();
        List<ProductDto> productDto = productList.stream().map(Product::toDto).collect(Collectors.toList());
        APIResponse apiResponse = APIResponse.success(productDto, HttpStatus.OK.value(), "Danh sach cac san pham: ");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getProductById(@PathVariable Integer id){
        Product product = productService.getProductById(id);
        ProductDto productDto = product.toDto();
        APIResponse apiResponse = APIResponse.success(productDto, HttpStatus.OK.value(), "Chi tiet san pham: ");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<APIResponse> getProductByName(@PathVariable String name) {
        Product product = productService.getProductByName(name);
        ProductDto productDto = product.toDto();
        APIResponse apiResponse = APIResponse.success(productDto, HttpStatus.OK.value(), "Chi tiet san pham: ");
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("delete/{id}")
    public  ResponseEntity<APIResponse> deleteProductById(@PathVariable Integer id){
        productService.deleteProductById(id);
        APIResponse apiResponse = APIResponse.success(null, HttpStatus.OK.value(), "Xoa san pham thanh cong");
        return ResponseEntity.ok(apiResponse);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<APIResponse> updateProduct(@PathVariable Integer id, @RequestBody ProductForm new_product){
        Product product = productService.updateProduct(id, new_product.getName(), new_product.getDescription(), new_product.getPrice());
        ProductDto productDto = product.toDto();
        APIResponse apiResponse = APIResponse.success(productDto, HttpStatus.OK.value(), "San pham sau khi chinh sua");
        return ResponseEntity.ok(apiResponse);
    }

}
