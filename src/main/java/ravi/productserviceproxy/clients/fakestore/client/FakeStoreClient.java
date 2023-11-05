package ravi.productserviceproxy.clients.fakestore.client;

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
import ravi.productserviceproxy.clients.fakestore.dto.FakeStoreProductDto;
import ravi.productserviceproxy.dto.ProductDto;
import ravi.productserviceproxy.dto.RatingDto;
import ravi.productserviceproxy.models.Product;
import ravi.productserviceproxy.models.Ratings;

import java.util.Arrays;
import java.util.List;
@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    // code for patch mapping
    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> l = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        return Arrays.asList(l.getBody());
    }

    public FakeStoreProductDto updateProduct(Long productId, Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setImage(product.getImageUrl());
        RatingDto ratingDto = new RatingDto();
        ratingDto.setCount(product.getRating().getCount());
        ratingDto.setRate(product.getRating().getRate());
        fakeStoreProductDto.setRating(ratingDto);

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity
                = requestForEntity(HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                productId
        );

        return fakeStoreProductDtoResponseEntity.getBody();
    }

    public FakeStoreProductDto deleteProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, productId);
        return responseEntity.getBody();
    }


}
