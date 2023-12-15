package com.price.low.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.price.low.request.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAvailable(boolean isAvailable);
}
