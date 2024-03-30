package com.example.productservice_proxy.repository;

import com.example.productservice_proxy.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Product save(Product product);

    List<Product> findByTitleEquals(String title, Pageable pageable);
}
