package ravi.productserviceproxy.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Ratings extends BaseModel{
    private double rate;
    private double count;
}
