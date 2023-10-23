package ravi.productserviceproxy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ravi.productserviceproxy.models.Product;
@Getter
@Setter
@ToString
public class ProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
    private RatingDto rating;
}
