package ravi.productserviceproxy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ravi.productserviceproxy.services.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getSinglProduct(@PathVariable("id") Long productId) {
        String product = this.productService.getSingleProduct(productId);
        return "Returning single product with id: " + product;
    }

}
