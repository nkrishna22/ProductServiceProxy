package ravi.productserviceproxy.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ravi.productserviceproxy.clients.IClientProductDto;
import ravi.productserviceproxy.clients.fakestore.client.FakeStoreClient;
import ravi.productserviceproxy.clients.fakestore.dto.FakeStoreProductDto;
import ravi.productserviceproxy.dto.ProductDto;
import ravi.productserviceproxy.models.Categories;
import ravi.productserviceproxy.models.Product;
import ravi.productserviceproxy.models.Ratings;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductServiceImpl implements ProductService {
    RestTemplateBuilder restTemplateBuilder;
    FakeStoreClient fakeStoreClient;
    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient = fakeStoreClient;
    }


    @Override
    public List<Product> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClient.getAllProducts();

        List<Product> answer = new ArrayList<>();
        for(FakeStoreProductDto p : fakeStoreProductDtos) {
            Product prd = getProduct(p);
            answer.add(prd);
        }
        return answer;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> productDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, productId);
        return getProduct(productDto.getBody());

    }
    @Override
    public Product addNewProduct(FakeStoreProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.postForEntity("https://fakestoreapi.com/products", productDto, ProductDto.class);
        Product product = getProduct((FakeStoreProductDto) productDto);
        return product;
    }

    @Override
    public Product patchProduct(Long productId, FakeStoreProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setCategory(new Categories());
        product.getCategory().setName(productDto.getCategory());
        product.setId(productDto.getId());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());
        product.setRating(new Ratings());
        product.getRating().setCount(productDto.getRating().getCount());
        product.getRating().setRate(productDto.getRating().getRate());
        FakeStoreProductDto fakeStoreProductDto1 = fakeStoreClient.updateProduct(productId, product);
        return getProduct(fakeStoreProductDto1);
    }

    @Override
    public Product updateProduct(Long productid) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.deleteProduct(productId);
        return getProduct(fakeStoreProductDto);
    }

    public Product getProduct(FakeStoreProductDto productDto) {
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
