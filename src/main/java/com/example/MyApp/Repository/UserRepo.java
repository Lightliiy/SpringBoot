package com.example.MyApp.Repository;

import com.example.MyApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);

}


