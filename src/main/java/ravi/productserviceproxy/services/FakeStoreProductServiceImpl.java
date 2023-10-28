package ravi.productserviceproxy.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ravi.productserviceproxy.dto.ProductDto;
import ravi.productserviceproxy.models.Categories;
import ravi.productserviceproxy.models.Product;
import ravi.productserviceproxy.models.Ratings;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductServiceImpl implements FakeStoreProductService {
    RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> productDtos = restTemplate
                .getForEntity("https://fakestoreapi.com/products", ProductDto[].class);

        List<Product> answer = new ArrayList<>();
        for(ProductDto p : productDtos.getBody()) {
            Product prd = getProduct(p);
            answer.add(prd);
        }
        return answer;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> productDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class, productId);
        return getProduct(productDto.getBody());

    }
    @Override
    public Product addNewProduct(ProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.postForEntity("https://fakestoreapi.com/products", productDto, ProductDto.class);
        Product product = getProduct(productDto);
        return product;
    }

    @Override
    public Product updateProduct(Long productId, ProductDto productDto) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }

    public Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories categories = new Categories();
        categories.setName(productDto.getCategory());
        product.setCategory(categories);
        product.setImageUrl(productDto.getImage());
        product.setDescription(productDto.getDescription());
        Ratings rating = new Ratings();
        rating.setRate(productDto.getRating().getRate());
        rating.setCount(productDto.getRating().getCount());
        product.setRating(rating);
        return product;
    }
}
