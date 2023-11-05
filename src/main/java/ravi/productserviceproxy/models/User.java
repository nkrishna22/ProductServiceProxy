package ravi.productserviceproxy.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel{
   private String email;
    private String username;
    private String password;
    private Names name;
    private Address address;
    private String phone;
}
