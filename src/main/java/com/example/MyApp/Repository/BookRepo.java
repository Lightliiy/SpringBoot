package com.example.MyApp.Repository;

import com.example.MyApp.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository <Book, Long> {
}