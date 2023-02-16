package co.NoSqlOrm.mongoDbDemo.controllers;

import co.NoSqlOrm.mongoDbDemo.entities.User;
import co.NoSqlOrm.mongoDbDemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @PostMapping("/post")
    public User createUser(@RequestBody User user){
       return userRepository.save(user);
    }

    @GetMapping("/get")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/get/{id}")
    public Optional<User> getUsers(@PathVariable Long id) throws Exception {
        Optional<User> user = userRepository.findById(String.valueOf(id));
        if(user.isPresent()){
            return Optional.of(user.get());
        } else{
            throw new Exception("User not found");
        }

    }
    @PutMapping("/put/{id}")
    public User editUser(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        return userRepository.save(user);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(String.valueOf(id));
    }
    @DeleteMapping("/delete")
    public void deleteAllUser(){
        userRepository.findAll();
    }

}
