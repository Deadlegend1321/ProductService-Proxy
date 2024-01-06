package com.example.productservice_proxy.services;

import com.example.productservice_proxy.clients.fakestore.client.FakeStoreClient;
import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//@Service
public class ProductService implements IProductService {

    //private RestTemplateBuilder restTemplateBuilder;

    private FakeStoreClient fakeStoreClient;
    public ProductService(
            //RestTemplateBuilder restTemplateBuilder,
            FakeStoreClient fakeStoreClient) {

       // this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient = fakeStoreClient;
    }

//    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod,String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
//        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
//        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
//        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
//    }

    @Override
    public List<Product> getAllProducts() {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<ProductDto[]> productDtos = restTemplate.getForEntity("https://fakestoreapi.com/products" , ProductDto[].class);
//        ProductDto[] productDto = productDtos.getBody();
        List<ProductDto> productDtos = fakeStoreClient.getAllProducts();
        List<Product> products = new ArrayList<>();
        for (ProductDto productDto1 : productDtos) {
            Product product = getProduct(productDto1);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product getSingleProduct(Long id) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<ProductDto> productDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}" , ProductDto.class, id);
        ProductDto productDto = fakeStoreClient.getSingleProduct(id);
        Product product = getProduct(productDto);
        return product;
    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    private Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImage());
        Categories categories = new Categories();
        categories.setName(productDto.getCategory());
        product.setCategory(categories);
        return product;
    }

//    @Override
//    public Product addNewProduct(ProductDto productDto) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        restTemplate.postForEntity("https://fakestoreapi.com/products", productDto, ProductDto.class);
//        ProductDto productDto1 = fakeStoreClient.addNewProduct(productDto);
//        return getProduct(productDto1);
//    }

    @Override
    public Product updateProduct(Long productiId, ProductDto productDto) {
        //RestTemplate restTemplate = restTemplateBuilder.build();
        //restTemplate.put("https://fakestoreapi.com/products/{id}", productDto, productiId);
//        ResponseEntity<ProductDto> productDtoResponseEntity = requestForEntity(HttpMethod.PATCH,
//                "https://fakestoreapi.com/products/{id}",
//                productDto,
//                ProductDto.class,
//                productiId);
//        ProductDto productDto1 = productDtoResponseEntity.getBody();
        ProductDto productDto1 = fakeStoreClient.updateProduct(productiId, productDto);
        return getProduct(productDto1);
    }

    @Override
    public Product deleteProduct(Long productId) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        restTemplate.delete("https://fakestoreapi.com/products/{id}", productId);
        ProductDto productDto1 = fakeStoreClient.deleteProduct(productId);
        return getProduct(productDto1);
    }
}
