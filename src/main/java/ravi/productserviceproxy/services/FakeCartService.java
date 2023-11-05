package ravi.productserviceproxy.services;

import ravi.productserviceproxy.models.Cart;

import java.util.List;

public interface FakeCartService {
    List<Cart> getAllCarts();
    String getSingleCart(Long cartId);

    String getUserCart(Long userId);
    String addNewCart();
    String updateCart(Long cartId);
    String deleteCart(Long cartId);
}
