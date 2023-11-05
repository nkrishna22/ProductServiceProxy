package ravi.productserviceproxy.services;

import ravi.productserviceproxy.clients.fakestore.dto.FakeStoreUserDto;

import java.util.List;

public interface UserService {
    List<FakeStoreUserDto> getAllUsers();
    String getSingleUser(Long userId);
    String addNewUser();
    String updateUser(Long userId);
    String deleteUser(Long userId);
}
