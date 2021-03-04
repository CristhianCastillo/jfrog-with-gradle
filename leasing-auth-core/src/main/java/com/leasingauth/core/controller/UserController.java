package com.leasingauth.core.controller;

import com.leasingauth.core.domain.manage.ManageUserService;
import com.leasingauth.util.dto.request.UserRequest;
import com.leasingauth.util.dto.response.ResponseDto;
import com.leasingauth.util.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private final ManageUserService manageUserService;

    @GetMapping
    public ResponseEntity<ResponseDto<List<UserResponse>>> getAllUsers() {
        return new ResponseEntity<>(ResponseDto.success(this.manageUserService.getAllUsers()), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseDto<UserResponse>> getUserById(@PathVariable Long userId) {
        return new ResponseEntity<>(ResponseDto.success(this.manageUserService.getUserById(userId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto<UserResponse>> createUser(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<>(ResponseDto.success(this.manageUserService.createUser(userRequest)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseDto<UserResponse>> updateUser(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<>(ResponseDto.success(this.manageUserService.updateUser(userRequest)), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseDto<String>> deleteUser(@PathVariable Long userId) {
        this.manageUserService.deleteUser(userId);
        return new ResponseEntity<>(ResponseDto.success("Successfully removed"), HttpStatus.OK);
    }
}
