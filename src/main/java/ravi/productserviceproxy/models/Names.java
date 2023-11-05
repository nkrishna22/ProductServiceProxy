package ravi.productserviceproxy.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Names extends BaseModel{
    private String firstname;
    private String lastname;
}
