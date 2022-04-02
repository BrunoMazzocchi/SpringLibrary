package com.example.library.LibraryAPI.web.config.controller;


import com.example.library.LibraryAPI.domain.dto.*;
import com.example.library.LibraryAPI.domain.service.*;
import com.example.library.LibraryAPI.web.security.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.*;

@RestController
@RequestMapping("/auth")
@ApiIgnore
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationmanager;

    @Autowired
    LibraryUserDetailService libraryUserDetailService;

    @Autowired
    private JWTUtil jwtUtil;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
        try {
            authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(request.getPassword(), request.getUsername()));

            //Envia los datos al JWT generator
            UserDetails userDetails = libraryUserDetailService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);

            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
