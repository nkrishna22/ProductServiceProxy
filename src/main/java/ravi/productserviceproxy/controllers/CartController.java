package ravi.productserviceproxy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ravi.productserviceproxy.clients.fakestore.client.FakeCartClient;
import ravi.productserviceproxy.models.Cart;
import ravi.productserviceproxy.services.FakeCartService;
import ravi.productserviceproxy.services.FakeCartServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    private FakeCartServiceImpl fakeCartService;
    private FakeCartClient fakeCartClient;

    public CartController(FakeCartClient fakeCartClient, FakeCartServiceImpl fakeCartService) {
        this.fakeCartClient = fakeCartClient;
        this.fakeCartService = fakeCartService;
    }

    @GetMapping("")
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> cts = this.fakeCartService.getAllCarts();
        ResponseEntity<List<Cart>> responseEntity = new ResponseEntity<>(cts, HttpStatus.OK);
        return responseEntity;
    }
}
