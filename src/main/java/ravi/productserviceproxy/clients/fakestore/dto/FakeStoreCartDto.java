package ravi.productserviceproxy.clients.fakestore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ravi.productserviceproxy.models.Products;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class FakeStoreCartDto {
    private Long id;
    private Long userId;
    private Date date;
    private List<Products> products;
}
