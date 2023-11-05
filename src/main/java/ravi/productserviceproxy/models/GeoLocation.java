package ravi.productserviceproxy.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GeoLocation extends BaseModel{
    private double lat;
    private double longi;
}
