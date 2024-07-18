package com.example.MyApp.Services;

import com.example.MyApp.Model.Book;
import com.example.MyApp.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {
    private final BookRepo bookRepo;

    @Autowired
    public BookServices(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublishedYear(bookDetails.getPublishedYear());
        book.setDescription(bookDetails.getDescription());
        book.setImage(bookDetails.getImage());
        return bookRepo.save(book);
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}
