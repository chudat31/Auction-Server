package com.example.product.controller;


import com.example.product.dto.ProductDto;
import com.example.product.form.ProductForm;
import com.example.product.models.History;
import com.example.product.models.Product;
import com.example.product.models.User;
import com.example.product.repository.ProductRepository;
import com.example.product.repository.UserRepository;
import com.example.product.response.APIResponse;
import com.example.product.service.HistoryService;
import com.example.product.service.ProductService;
import com.example.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

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

    @GetMapping("/highest/{username}")
    public ResponseEntity<APIResponse> getProductByUsername(@PathVariable String username){
        List<Product> productList = productRepository.findByUsername(username);
        APIResponse apiResponse = APIResponse.success(productList, HttpStatus.OK.value(), "Chi tiet san pham: ");
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
        Product product = productService.updateProduct(id, new_product.getPrice());
        String username = new_product.getUsername();
        User user = userRepository.findByUsername(username);
        product.setUser(user);
        product.setUsername(username);
        History history = new History();
        history.setPrice(new_product.getPrice());
        history.setDatetime(LocalDateTime.now());
        history.setName(product.getName());
        history.setProduct(product);
        history.setUsername(username);
        history.setUser(user);
        historyService.addNewHistory(history);
        ProductDto productDto = product.toDto();
        APIResponse apiResponse = APIResponse.success(productDto, HttpStatus.OK.value(), "San pham sau khi chinh sua");
        return ResponseEntity.ok(apiResponse);
    }

}
