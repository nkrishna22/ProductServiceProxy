package ravi.productserviceproxy.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Cart extends BaseModel{
    private Long userId;
    private Date date;
    private List<Products> products;
}
