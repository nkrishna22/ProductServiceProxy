package ravi.productserviceproxy.services;

import ravi.productserviceproxy.dto.ProductDto;
import ravi.productserviceproxy.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    String getSingleProduct(Long productId);
    Product addNewProduct(ProductDto productDto);
    Product updateProduct(Long productId, ProductDto productDto);
    String deleteProduct(Long productId);
}
