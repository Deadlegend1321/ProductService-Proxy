package com.example.productservice_proxy.services;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.repository.ProductElasticSearchRepo;
import com.example.productservice_proxy.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements IProductService {

    ProductRepo productRepo;

    ProductElasticSearchRepo productElasticSearchRepo;

    public SelfProductService(ProductRepo productRepo, ProductElasticSearchRepo productElasticSearchRepo) {
        this.productRepo = productRepo;
        this.productElasticSearchRepo = productElasticSearchRepo;
    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        this.productRepo.save(product);
        this.productElasticSearchRepo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long productiId, ProductDto productDto) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }
}
