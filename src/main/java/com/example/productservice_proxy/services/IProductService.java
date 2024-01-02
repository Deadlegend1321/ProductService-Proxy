package com.example.productservice_proxy.services;

import com.example.productservice_proxy.dtos.ProductDto;

public interface IProductService {
    String getAllProducts();

    String getSingleProduct(Long id);

    String addNewProduct(ProductDto productDto);

    String updateProduct(Long productiId, ProductDto productDto);

    String deleteProduct(Long productId);
}
