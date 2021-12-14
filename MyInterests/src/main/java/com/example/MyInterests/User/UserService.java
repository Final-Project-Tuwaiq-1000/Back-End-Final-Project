package com.example.MyInterests.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String id){
        Long user_id = Long.parseLong(id);
        return userRepository.findById(user_id).orElse(null);
    }

    public ResponseEntity<?> createUser(User user){
        if (userRepository.findByEmail(user.getEmail()) == null){

            if (userRepository.findByUserName(user.getUserName()) == null){
                 userRepository.save(user);
                 return ResponseEntity.ok().body(userRepository.findByEmail(user.getEmail()));
            }
            else{
                return ResponseEntity.status(404).body("User Name already exist");
            }

        }
        else {
            return ResponseEntity.status(404).body("Email already exist");
        }

    }

    public ResponseEntity<?> login(LoginForm loginForm){
        if (userRepository.findByEmail(loginForm.getEmail())!=null)
        {
            if (loginForm.getPassword().equals(userRepository.findByEmail(loginForm.getEmail()).getPassword()))
            {
                return ResponseEntity.ok().body(userRepository.findByEmail(loginForm.getEmail()));
            }
            else {
                return ResponseEntity.status(404).body("Wrong Password");
            }
        }
        else {
            return ResponseEntity.status(404).body("User Not Found");
        }
    }


    public void updateUser(String id, User data){
        Long user_id = Long.parseLong(id);
        User user = userRepository.findById(user_id).orElse(null);

        if (user !=null){
            user.setUserName(data.getUserName());
            user.setEmail(data.getEmail());
            user.setPassword(data.getPassword());
            user.setMoreInfo(data.getMoreInfo());
            userRepository.save(user);
        }
    }
}
