package com.bunnyshell.templates.springbootrestapi.controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bunnyshell.templates.springbootrestapi.exception.ResourceNotFoundException;
import com.bunnyshell.templates.springbootrestapi.model.Book;
import com.bunnyshell.templates.springbootrestapi.repository.BookRepository;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/available")
    public List<Book> getAvailableBooks() {
        return bookRepository.findByAvailable(true);
    }
    
    @GetMapping("/books/deleted")
    public List<Book> getDeletedBooks() {
    	List<Book> deleted = new ArrayList () ;
    	deleted.add(new Book ("book_title", "book_description", false, Date.from(Instant.now()), Date.from(Instant.now())));
        return deleted ;
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId)
        throws ResourceNotFoundException {
        Book book = bookRepository
                .findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found on :: " + bookId));

        return ResponseEntity.ok(book);
    }

    @PostMapping("/books")
    public Book createBook(@Validated @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(
        @PathVariable(value = "id") Long bookId, @Validated @RequestBody Book bookDetails)
        throws ResourceNotFoundException {

        Book book = bookRepository
                .findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found on :: " + bookId));

        book.setTitle(bookDetails.getTitle());
        book.setDescription(bookDetails.getDescription());
        book.setAvailable(bookDetails.isAvailable());
        book.setUpdatedAt(new Date());

        final Book updatedBook = bookRepository.save(book);

        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable(value = "id") Long bookId) throws Exception {
        Book book = bookRepository
            .findById(bookId)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found on :: " + bookId));

        bookRepository.delete(book);
    }

    @DeleteMapping("/books")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAll() throws Exception {
        bookRepository.deleteAll();
    }
}
