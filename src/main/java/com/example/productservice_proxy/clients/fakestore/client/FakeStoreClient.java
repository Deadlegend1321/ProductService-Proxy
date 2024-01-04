package com.example.productservice_proxy.clients.fakestore.client;

import com.example.productservice_proxy.dtos.ProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreClient {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public List<ProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> productDtos = restTemplate.getForEntity("https://fakestoreapi.com/products" , ProductDto[].class);
        return Arrays.asList(productDtos.getBody());
    }

    public ProductDto getSingleProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> productDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}" , ProductDto.class, id);
        return productDto.getBody();
    }

    public ProductDto addNewProduct(ProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> productDtoResponseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products", productDto, ProductDto.class);
        return productDtoResponseEntity.getBody();
    }

    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> productDtoResponseEntity = requestForEntity(HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                productDto,
                ProductDto.class,
                productId);
        return productDtoResponseEntity.getBody();
    }

    public ProductDto deleteProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> productDtoResponseEntity = requestForEntity(HttpMethod.DELETE,
                "https://fakestoreapi.com/products/{id}",
                null,
                ProductDto.class,
                productId);
        return productDtoResponseEntity.getBody();
    }
}
