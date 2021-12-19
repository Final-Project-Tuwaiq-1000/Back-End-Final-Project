package com.example.MyInterests.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;

@RestController
@RequestMapping(path = "user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List <User> getUsers (){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody SignUpForm signUpForm){
        return userService.createUser(signUpForm);
    }

//    @PostMapping("/logIn")
//    public ResponseEntity<?> logIn(@RequestBody LoginForm loginForm){
//        return userService.login(loginForm);
//    }

    @PutMapping("/{id}")
    public void  updateUser(@PathVariable String id, @RequestBody User data){
        userService.updateUser(id,data);
    }
}


//class LoginForm{
//    private String email;
//    private String password;
//
//    public LoginForm(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}

class SignUpForm {
    private User user ;
    private Long role_id;

    public SignUpForm(User user, Long role_id) {
        this.user = user;
        this.role_id = role_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}