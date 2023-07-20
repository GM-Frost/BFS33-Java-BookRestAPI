package com.takeo.BookApiSecond.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takeo.BookApiSecond.model.Book;
import com.takeo.BookApiSecond.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	public List<Book>getAllBooks(){
		return bookService.getAllBooks();
	}

	@GetMapping("/")
	public String sayHello() {
		return  "Helloo";
	}

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Integer id) {
		return bookService.getBookById(id);
	}

	@PostMapping("/insert")
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}

	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}

	@DeleteMapping
	public void deleteBook(@PathVariable Integer id) {
		bookService.deleteBook(id);
	}
}
