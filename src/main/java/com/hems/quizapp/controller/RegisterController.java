package com.hems.quizapp.controller;


    import com.hems.quizapp.service.RegisterService;
    import com.hems.quizapp.model.Register;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.BadCredentialsException;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("auth")
    public class RegisterController {
        @Autowired
        private RegisterService registerService;

        @Autowired
        AuthenticationManager authenticationManager;
        @PostMapping("register")
        public ResponseEntity<String> addUser(@RequestBody Register registerId){
            Register savedUser = registerService.addUser(registerId);

            if (savedUser != null && savedUser.getId() != null) {
                return ResponseEntity.ok("User saved successfully: " + savedUser.getUsername());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User not saved!");
            }

        }
        @GetMapping("registers")
        public List<Register> getUser(){
            return registerService.getUsers();

        }

        @PostMapping("login")
        public String login(@RequestBody Register user) {
            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
                );

                // Authentication successful
                if (authentication.isAuthenticated()) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    return "Login successful!";
                } else {
                    return "Login failed!";
                }
            } catch (BadCredentialsException e) {
                return "Invalid username or password!";
            }
        }




    }