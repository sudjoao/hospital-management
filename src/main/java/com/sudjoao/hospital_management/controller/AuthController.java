package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.dto.UserInputDTO;
import com.sudjoao.hospital_management.dto.UserOutputDTO;
import com.sudjoao.hospital_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("sign_up")
    ResponseEntity<UserOutputDTO> createUser(@RequestBody UserInputDTO userDTO, UriComponentsBuilder uriComponentsBuilder) {
        var user = userRepository.save(userDTO.toDomain());
        var uri = uriComponentsBuilder.path("/doctors/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(UserOutputDTO.fromDomain(user));
    }
}
