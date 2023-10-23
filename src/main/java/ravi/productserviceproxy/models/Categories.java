package ravi.productserviceproxy.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Categories {
    private long id;
    private String name;
    private String description;
    private List<Product> products;
}
