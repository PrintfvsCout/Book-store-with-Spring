package com.example.EMTProdKniga.repo;

import com.example.EMTProdKniga.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>
{
    public List<Book> findByCategoryId(Long catId);

}
