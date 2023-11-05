package ravi.productserviceproxy.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Products extends BaseModel{
    private long productId;
    private int quantity;
}
