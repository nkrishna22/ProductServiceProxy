package ravi.productserviceproxy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ravi.productserviceproxy.models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Product save(Product product);
}
