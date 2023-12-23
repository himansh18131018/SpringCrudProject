package io.aiven.spring.msql.demo.controller;

import io.aiven.spring.msql.demo.entity.User;
import io.aiven.spring.msql.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public @ResponseBody User addUser(@RequestParam String name, @RequestParam String email){
        User springUser = new User();
        springUser.setName(name);
        springUser.setEmail(email);
        userRepository.save(springUser);
        return springUser;
    }

    @GetMapping("/list")
    public @ResponseBody Iterable<User> getAll(){
        return userRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public @ResponseBody User updatUser(@PathVariable Integer id, @RequestBody User client){
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        user.setName(client.getName());
        user.setEmail(client.getEmail());
        userRepository.save(user);
        return user;
    }

    @DeleteMapping("/delete")
    public @ResponseBody User deleteUser(@RequestParam Integer id){
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);;
        userRepository.deleteById(id);
        return user;
    }
}
