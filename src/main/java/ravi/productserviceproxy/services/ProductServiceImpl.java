package ravi.productserviceproxy.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ravi.productserviceproxy.dto.ProductDto;
import ravi.productserviceproxy.models.Product;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    RestTemplateBuilder restTemplateBuilder;
    public ProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return null;
    }

    @Override
    public String getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDto productDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class, productId).getBody();
        return productDto.toString();

    }
    @Override
    public Product addNewProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, ProductDto productDto) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }
}
