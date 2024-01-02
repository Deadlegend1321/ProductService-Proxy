package com.example.productservice_proxy.services;

import com.example.productservice_proxy.dtos.ProductDto;

public class ProductService implements IProductService {

    @Override
    public String getAllProducts() {
        return "Product 1, Product 2, Product 3";
    }

    @Override
    public String getSingleProduct(Long id) {
        return "Product 1";
    }

    @Override
    public String addNewProduct(ProductDto productDto) {
        return "Product 1";
    }

    @Override
    public String updateProduct(Long productiId, ProductDto productDto) {
        return "Product 1";
    }

    @Override
    public String deleteProduct(Long productId) {
        return "Product 1";
    }
}
