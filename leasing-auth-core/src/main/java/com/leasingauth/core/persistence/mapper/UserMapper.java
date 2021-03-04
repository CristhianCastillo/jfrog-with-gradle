package com.leasingauth.core.persistence.mapper;

import com.leasingauth.core.persistence.entity.UserEntity;
import com.leasingauth.util.dto.request.UserRequest;
import com.leasingauth.util.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserEntity convertRequestToEntity(UserRequest userRequest) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(userRequest, UserEntity.class);
    }

    public UserResponse convertEntityToResponse(UserEntity userEntity) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(userEntity, UserResponse.class);
    }
}
