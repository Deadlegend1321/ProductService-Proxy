package com.example.productservice_proxy.controllers;

import com.example.productservice_proxy.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("")
    public String getAllProducts() {
        return "products";
    }

    @GetMapping("/{productId}")
    public String getProductById(@PathVariable("productId") Long productId) {
        return "return product by id" + productId;
    }

    @PostMapping("")
    public String addNewProduct(@RequestBody ProductDto productDto) {
        return "Adding new Product" + productDto;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {
        return "Updating product with id" + productId + "with" + productDto;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "Deleting product with id" + productId;
    }
}
