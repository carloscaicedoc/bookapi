package com.carloscaicedo.booksapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.carloscaicedo.booksapi.models.Book;
import com.carloscaicedo.booksapi.services.BookService;

@Controller
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String home() {
		return "books.jsp";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String showOneBook(@PathVariable("id")Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show.jsp";		
	}
	
	@GetMapping("/books/new")
	public String createForm(@ModelAttribute("book")Book book) {
		return "publish.jsp";
	}
	
	@PostMapping("/books")
    public String processForm(@Valid @ModelAttribute("book")Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "publish.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";			
		}		
	}
	
}
