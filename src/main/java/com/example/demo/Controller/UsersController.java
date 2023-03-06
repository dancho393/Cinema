package com.example.demo.Controller;

import com.example.demo.CinemaRelated.Users;
import com.example.demo.Repository.UserRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }
    @GetMapping
    public ResponseEntity getAllUsers() {

        return  ResponseEntity.ok(this.userRepository.findAll());
    }
    @GetMapping("/{id}")
    public Users getUser(@PathVariable Long id) {

        return  userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users savedUser = this.userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        this.userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
        Users existingUser = this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setRole(user.getRole());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        Users savedUser = this.userRepository.save(existingUser);
        return ResponseEntity.ok(savedUser);
    }

}
