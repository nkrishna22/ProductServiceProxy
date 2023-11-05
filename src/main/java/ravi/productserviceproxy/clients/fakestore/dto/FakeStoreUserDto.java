package ravi.productserviceproxy.clients.fakestore.dto;

import lombok.Getter;
import lombok.Setter;
import ravi.productserviceproxy.models.Address;
import ravi.productserviceproxy.models.Names;
@Getter
@Setter
public class FakeStoreUserDto {
    public class User {
        private long id;
        private String email;
        private String username;
        private String password;
        private Names name;
        private Address address;
        private String phone;
    }
}
