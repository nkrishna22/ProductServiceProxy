package ravi.productserviceproxy.clients.fakestore.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ravi.productserviceproxy.clients.fakestore.dto.FakeStoreUserDto;

import java.util.Arrays;
import java.util.List;
@Component
public class FakeStoreUserClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreUserClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public List<FakeStoreUserDto> getAllUsers() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreUserDto[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/users", FakeStoreUserDto[].class);
        return Arrays.asList(responseEntity.getBody());
    }
}
