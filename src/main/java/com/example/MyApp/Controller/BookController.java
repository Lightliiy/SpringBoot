package com.example.MyApp.Controller;

import com.example.MyApp.Model.Book;
import com.example.MyApp.Services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookServices bookServices;

    @Autowired
    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookServices.getAllBooks();
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookServices.addBook(book);
    }

    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookServices.updateBook(id, bookDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookServices.deleteBook(id);
    }
}
