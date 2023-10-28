package ravi.productserviceproxy.models;

import lombok.Getter;
import lombok.Setter;
import ravi.productserviceproxy.dto.RatingDto;

@Getter
@Setter
public class Product {
    private long id;
    private String title;
    private double price;
    private Categories category;
    private String description;
    private String imageUrl;
    private Ratings rating;
}
