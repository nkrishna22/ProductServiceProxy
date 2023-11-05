package ravi.productserviceproxy.services;

import org.springframework.stereotype.Service;
import ravi.productserviceproxy.clients.fakestore.dto.FakeStoreProductDto;
import ravi.productserviceproxy.models.Product;
import ravi.productserviceproxy.repositories.ProductRepo;

import java.util.List;
@Service
public class SelfProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

    public SelfProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public Product addNewProduct(FakeStoreProductDto productDto) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId) {
        return null;
    }

    @Override
    public Product patchProduct(Long productId, FakeStoreProductDto productDto) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }
}
