//package com.example.product.controller;
//
//import com.example.product.models.AuthRequest;
//import com.example.product.models.AuthResponse;
//import com.example.product.models.JwtTokenUtil;
//import com.example.product.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//public class LoginController {
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    JwtTokenUtil jwtTokenUtil;
//    @PostMapping("/user/login")
//    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
//            );
//            User user = (User) authentication.getPrincipal();
//            String accessToken = jwtTokenUtil.generateAccessToken(user);
//            AuthResponse authResponse = new AuthResponse(user.getUsername(), accessToken);
//            return ResponseEntity.ok(authResponse);
//        } catch (BadCredentialsException exception) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }
//}
