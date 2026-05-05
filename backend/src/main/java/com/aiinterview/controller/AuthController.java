
// package com.aiinterview.controller;

// import com.aiinterview.model.User;
// import com.aiinterview.repository.UserRepository;
// import com.aiinterview.security.JwtUtil;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.Map;

// @RestController
// public class AuthController {

//     @Autowired
//     private JwtUtil jwtUtil;

//     @Autowired
//     private UserRepository userRepository;

//     @PostMapping("/login")
//     public Map<String, String> login(@RequestBody Map<String, String> user) {

//         String email = user.get("username"); // frontend se username aa raha hai (email)
//         String password = user.get("password");

//         User dbUser = userRepository.findByEmail(email);

//         if (dbUser != null && dbUser.getPassword().equals(password)) {

//             String token = jwtUtil.generateToken(email);
//             return Map.of("token", token);

//         } else {
//             throw new RuntimeException("Invalid Credentials");
//         }
//     }
// }





package com.aiinterview.controller;

import com.aiinterview.model.User;
import com.aiinterview.repository.UserRepository;
import com.aiinterview.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {

        String email = user.get("username");
        String password = user.get("password");

        Optional<User> dbUser = userRepository.findByEmail(email);

        if (dbUser.isPresent() && dbUser.get().getPassword().equals(password)) {

            String token = jwtUtil.generateToken(email);
            return Map.of("token", token);

        } else {
            throw new RuntimeException("Invalid Credentials");
        }
    }
}
