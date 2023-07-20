package com.takeo.BookApiSecond.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.takeo.BookApiSecond.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
