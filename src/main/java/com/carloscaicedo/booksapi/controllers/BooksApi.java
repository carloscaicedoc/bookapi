package com.carloscaicedo.booksapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carloscaicedo.booksapi.models.Book;
import com.carloscaicedo.booksapi.services.BookService;

@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    
//    Option 2
//    @Autowired
//    private BookService bookService
    
    @RequestMapping("/api/books")
    public List<Book> showAll() {
    	return bookService.allBooks();
    }
    
    @PostMapping(value="/api/books")
    public Book create(
    		@RequestParam(value="title") String title,
    		@RequestParam(value="description") String desc,
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
    	Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
  
    }
    		
    @RequestMapping("/api/book/{id}")
    public Book showOne(@PathVariable("id") Long id) {
    	Book book = bookService.findBook(id);
    	return book;
    }
    
    // other methods removed for brevity
    @PutMapping(value="/api/books/{id}")
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
    	Book book = bookService.findBook(id);
    	book.setTitle(title);
    	book.setDescription(desc);
    	book.setLanguage(lang);
    	book.setNumberOfPages(numOfPages);
        return bookService.updateBook(book);
        
        // option B
        // Book book = new Book(title, description, lang, numOfPages);
        // book.setId(id);    	
        // book = service.updateBook(book);       
        // return book;
        
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}