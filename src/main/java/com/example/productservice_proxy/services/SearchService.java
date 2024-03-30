package com.example.productservice_proxy.services;

import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.models.SortParam;
import com.example.productservice_proxy.repository.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class SearchService {

    private ProductRepo productRepo;

    public SearchService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> searchProducts(String query, int pageNumber, int pageSize, List<SortParam> sortParams) {
        //Sort sort = Sort.by("title").descending().and(Sort.by("price").descending());
        Sort sort;
        if (sortParams.get(0).getDirection().equals("ASC")) {
            sort = Sort.by(sortParams.get(0).getParamName()).ascending();
        } else {
            sort = Sort.by(sortParams.get(0).getParamName()).descending();
        }

        for(int i = 1; i < sortParams.size(); i++) {
            if (sortParams.get(i).getDirection().equals("ASC")) {
                sort = sort.and(Sort.by(sortParams.get(i).getParamName()).ascending());
            } else {
                sort = sort.and(Sort.by(sortParams.get(i).getParamName()).descending());
            }
        }
        return productRepo.findByTitleEquals(query, (Pageable) PageRequest.of(pageNumber, pageSize, sort));

    }
}
