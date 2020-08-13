package com.example.EMTProdKniga.service;

import com.example.EMTProdKniga.model.Book;
import com.example.EMTProdKniga.model.Category;
import com.example.EMTProdKniga.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book)
    {
        bookRepository.save(book);
    }

    public List<Book>getAllBooks()
    {
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(Long id)
    {
        return bookRepository.findById(id);
    }

    public void updateBook( Book book)
    {
        bookRepository.save(book);
    }

    public void deleteBook(Long id)
    {
        bookRepository.deleteById(id);
    }
}
