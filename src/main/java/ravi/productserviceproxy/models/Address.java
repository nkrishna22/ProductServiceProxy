package ravi.productserviceproxy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address extends BaseModel{
    private String city;
    private String street;
    private long number;
    private String zipcode;
    @ManyToOne
    private GeoLocation geolocation;
    private String phone;
}
