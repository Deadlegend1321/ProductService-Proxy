package com.example.productservice_proxy.services;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long id);

    //Product addNewProduct(ProductDto productDto);

    Product addNewProduct(Product product);

    Product updateProduct(Long productiId, ProductDto productDto);

    Product deleteProduct(Long productId);
}
