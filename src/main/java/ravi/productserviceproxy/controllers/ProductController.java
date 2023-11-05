package ravi.productserviceproxy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ravi.productserviceproxy.clients.IClientProductDto;
import ravi.productserviceproxy.clients.fakestore.dto.FakeStoreProductDto;
import ravi.productserviceproxy.dto.ProductDto;
import ravi.productserviceproxy.models.Categories;
import ravi.productserviceproxy.models.Product;
import ravi.productserviceproxy.models.Ratings;
import ravi.productserviceproxy.services.FakeStoreProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private FakeStoreProductServiceImpl productService;

    public ProductController(FakeStoreProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSinglProduct(@PathVariable("id") Long productId) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        headers.add("auth-token", "heyaccess");
        try {
            Product product = this.productService.getSingleProduct(productId);
            if(productId < 1) {
                throw new IllegalArgumentException("Product id is not valid");
            }
            ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, headers, HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Product> addNewProduct(@RequestBody FakeStoreProductDto productDto) {
        Product product = this.productService.addNewProduct(productDto);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> patchProduct(@PathVariable("productId") Long productId, @RequestBody FakeStoreProductDto productDto) {

        Product product1 = this.productService.patchProduct(productId, productDto);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product1, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Long productId) {
        Product product = this.productService.deleteProduct(productId);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
    }

}
