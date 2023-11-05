package ravi.productserviceproxy.clients.fakestore.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ravi.productserviceproxy.clients.fakestore.dto.FakeStoreCartDto;
import ravi.productserviceproxy.models.Cart;

import java.util.Arrays;
import java.util.List;
@Component
public class FakeCartClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeCartClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public List<FakeStoreCartDto> getAllCarts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartDto[]> c = restTemplate.getForEntity("https://fakestoreapi.com/carts", FakeStoreCartDto[].class);
        return Arrays.asList(c.getBody());
    }

}
