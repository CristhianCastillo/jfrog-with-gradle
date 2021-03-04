package com.leasingauth.core.domain.service;

import com.leasingauth.core.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserEntity> getAll();

    UserEntity getById(Long id);

    UserEntity save(UserEntity userEntity);

    UserEntity update(UserEntity userEntity);

    void delete(UserEntity userEntity);

}
