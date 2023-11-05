package ravi.productserviceproxy.services;

import org.springframework.stereotype.Service;
import ravi.productserviceproxy.clients.fakestore.client.FakeStoreUserClient;
import ravi.productserviceproxy.clients.fakestore.dto.FakeStoreProductDto;
import ravi.productserviceproxy.clients.fakestore.dto.FakeStoreUserDto;
import ravi.productserviceproxy.models.User;

import java.util.List;

@Service
public class FakeStoreUserServiceImpl implements UserService{
    private FakeStoreUserClient fakeStoreUserClient;

    public FakeStoreUserServiceImpl(FakeStoreUserClient fakeStoreUserClient) {
        this.fakeStoreUserClient = fakeStoreUserClient;
    }

    @Override
    public List<FakeStoreUserDto> getAllUsers() {
        List<FakeStoreUserDto> usrs = fakeStoreUserClient.getAllUsers();
        return usrs;
    }

    @Override
    public String getSingleUser(Long userId) {
        return null;
    }

    @Override
    public String addNewUser() {
        return null;
    }

    @Override
    public String updateUser(Long userId) {
        return null;
    }

    @Override
    public String deleteUser(Long userId) {
        return null;
    }


}
