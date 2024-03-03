package com.example.productservice_proxy.repository;

import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    void saveProductsAndCategory() {
        Categories categories = new Categories();
        categories.setName("Electronics");
        categories.setDescription("Electronics");
        categoryRepo.save(categories);

        Product product = new Product();
        product.setTitle("Samsung");
        product.setDescription("Samsung");
        product.setPrice(1000); 
        product.setCategory(categories);

        productRepo.save(product);
    }
}