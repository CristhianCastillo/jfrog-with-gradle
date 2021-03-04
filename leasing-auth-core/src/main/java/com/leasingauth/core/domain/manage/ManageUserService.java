package com.leasingauth.core.domain.manage;

import com.leasingauth.util.dto.request.UserRequest;
import com.leasingauth.util.dto.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManageUserService {

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long userId);

    UserResponse createUser(UserRequest userRequest);

    UserResponse updateUser(UserRequest userRequest);

    void deleteUser(Long userId);
}
