package com.example.EMTProdKniga.controller;

import com.example.EMTProdKniga.model.Book;
import com.example.EMTProdKniga.model.Category;
import com.example.EMTProdKniga.service.BookService;
import com.example.EMTProdKniga.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController
{
    private final BookService bookService;
    private  final CategoryService categoryService;

    public BookController(BookService bookService, CategoryService categoryService)
    {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping("/bookpage")
    public String addBookPage(Model model)
    {
        model.addAttribute("bookObject", new Book());
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories" , categories);
        return "add-product";
    }

    @GetMapping("/books")
    public String getAllBooks(Model model)
    {
        List<Book> bookList = bookService.getAllBooks();
        model.addAttribute("books",bookList);
        return "products";
    }

    @GetMapping("/addbook")
    public String  addBook(Model model, @Valid Book book, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("bookObject", new Book());
            List<Category> categories = categoryService.getCategories();
            model.addAttribute("categories" , categories);
            return "add-product";
        }
        model.addAttribute("newbook", new Book());
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping ("/book/{id}/delete")
    public String deleteBook(@PathVariable Long id)
    {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    /*
    @PostMapping("/addbook/{topicId}/books")
    public void addBook(@RequestBody Book book, @PathVariable Long topicId)
    {
        book.setCategory(new Category(topicId, "",""));
        bookService.addBook(book);
    }




    @GetMapping("/book/{categoryId}/categories/{id}")
    public Optional<Book> getBook(@PathVariable Long id)
    {
        return bookService.getBook(id);
    }

    @PutMapping("/updatebook/{topicId}/books/{id}")
    public void updateBook(@PathVariable Long topicId, @PathVariable Long id , @RequestBody Book book)
    {
         book.setCategory(new Category(topicId, "",""));
         bookService.updateBook(book);
    }

    @DeleteMapping("/delete/book/{id}")
    public void deleteBook(@PathVariable Long id)
    {
        bookService.deleteBook(id);
    }
     */

}
