package org.usman.dogs_cats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.usman.dogs_cats.dto.ResponseDto;
import org.usman.dogs_cats.dto.UserDto;
import org.usman.dogs_cats.mapper.UserMapper;
import org.usman.dogs_cats.service.UserService;

@RestController

@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private UserMapper mapper;

    @PostMapping("/")
    public ResponseEntity<ResponseDto>  saveUser(@RequestBody UserDto user){
        service.saveUser(mapper.toEntity(user));
        return  ResponseEntity.ok(new ResponseDto().builder().message("User is registered").build());
    }
}
