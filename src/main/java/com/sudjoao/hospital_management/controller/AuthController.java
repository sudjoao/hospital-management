package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.domain.User;
import com.sudjoao.hospital_management.dto.SignOutputDTO;
import com.sudjoao.hospital_management.dto.UserInputDTO;
import com.sudjoao.hospital_management.repository.UserRepository;
import com.sudjoao.hospital_management.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

//    @PostMapping("sign_up")
//    ResponseEntity<UserOutputDTO> createUser(@RequestBody UserInputDTO userDTO, UriComponentsBuilder uriComponentsBuilder) {
//        var user = userRepository.save(userDTO.toDomain());
//        var uri = uriComponentsBuilder.path("/doctors/{id}").buildAndExpand(user.getId()).toUri();
//        return ResponseEntity.created(uri).body(UserOutputDTO.fromDomain(user));
//    }

    @PostMapping("sign_in")
    ResponseEntity<SignOutputDTO> signInUser(@RequestBody UserInputDTO userDTO) {
        var token = new UsernamePasswordAuthenticationToken(userDTO.username(), userDTO.password());
        var auth = manager.authenticate(token);
        var jwtToken = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok().body(SignOutputDTO.of(jwtToken));
    }
}
