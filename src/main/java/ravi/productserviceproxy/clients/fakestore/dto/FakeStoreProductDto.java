package ravi.productserviceproxy.clients.fakestore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ravi.productserviceproxy.clients.IClientProductDto;
import ravi.productserviceproxy.dto.RatingDto;
@Getter
@Setter
@ToString
public class FakeStoreProductDto implements IClientProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
    private RatingDto rating;
}
