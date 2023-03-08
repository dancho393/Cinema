package com.example.demo.Repository;

import com.example.demo.CinemaRelated.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUsernameAndPassword(String username, String password);
}
