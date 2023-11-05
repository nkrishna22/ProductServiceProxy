package ravi.productserviceproxy.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ravi.productserviceproxy.clients.fakestore.client.FakeCartClient;
import ravi.productserviceproxy.clients.fakestore.dto.FakeStoreCartDto;
import ravi.productserviceproxy.models.Cart;
import ravi.productserviceproxy.models.Products;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeCartServiceImpl implements FakeCartService{
    private FakeCartClient fakeCartClient;
    public FakeCartServiceImpl(FakeCartClient fakeCartClient) {
        this.fakeCartClient = fakeCartClient;
    }

    @Override
    public List<Cart> getAllCarts() {
        List<FakeStoreCartDto> fakeStoreCartDtos = this.fakeCartClient.getAllCarts();
        List<Cart> answer = new ArrayList<>();
        for(FakeStoreCartDto p : fakeStoreCartDtos) {
            Cart prdCard = getCart(p);
            answer.add(prdCard);
        }
        return answer;
    }

    public String getSingleCart(Long cartId) {
        return null;
    }

    public String getUserCart(Long userId) {
        return null;
    }
   public String addNewCart() {
       return null;
   }
    public String updateCart(Long cartId) {
        return null;
    }
    public String deleteCart(Long cartId) {
        return null;
    }

    public Cart getCart(FakeStoreCartDto fakeStoreCartDto) {
        Cart cart = new Cart();
        cart.setId(fakeStoreCartDto.getId());
        cart.setDate(fakeStoreCartDto.getDate());
        cart.setUserId(fakeStoreCartDto.getUserId());
        List<Products> products = new ArrayList<>();
        for(Products p : fakeStoreCartDto.getProducts()) {
            Products prd = new Products();
            prd.setProductId(p.getProductId());
            prd.setQuantity(p.getQuantity());
            products.add(prd);
        }
        cart.setProducts(products);


        return cart;
    }
}
