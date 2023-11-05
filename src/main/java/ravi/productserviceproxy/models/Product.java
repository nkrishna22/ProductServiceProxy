package ravi.productserviceproxy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import ravi.productserviceproxy.dto.RatingDto;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private double price;
    @ManyToOne
    private Categories category;
    private String description;
    private String imageUrl;
    @ManyToOne
    private Ratings rating;
}
