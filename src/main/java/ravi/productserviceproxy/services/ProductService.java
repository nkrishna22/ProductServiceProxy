package ravi.productserviceproxy.services;

import ravi.productserviceproxy.clients.IClientProductDto;
import ravi.productserviceproxy.clients.fakestore.dto.FakeStoreProductDto;
import ravi.productserviceproxy.dto.ProductDto;
import ravi.productserviceproxy.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(Long productId);
    Product addNewProduct(FakeStoreProductDto productDto);
    Product updateProduct(Long productId);

    Product patchProduct(Long productId, FakeStoreProductDto productDto);
    Product deleteProduct(Long productId);
}
