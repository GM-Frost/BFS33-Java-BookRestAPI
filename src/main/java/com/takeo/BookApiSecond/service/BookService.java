package com.takeo.BookApiSecond.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.takeo.BookApiSecond.model.Book;
import com.takeo.BookApiSecond.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public List<Book>getAllBooks(){
		return bookRepository.findAll();
	}
	//Getting Single ID
	public Book getBookById(Integer id) {
    	return bookRepository.findById(id).orElse(null);
	}
	//Creating
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	//Updating
	public Book updateBook(Integer id, Book book) {
		Book existingBook = bookRepository.findById(id).orElse(null);
		if(existingBook!=null) {
			existingBook.setTitle(book.getTitle());
			existingBook.setAuthor(book.getAuthor());
			
			return bookRepository.save(existingBook);
		}
		return null;
	}
	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}
}
