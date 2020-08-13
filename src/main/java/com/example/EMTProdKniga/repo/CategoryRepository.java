package com.example.EMTProdKniga.repo;

import com.example.EMTProdKniga.model.Book;
import com.example.EMTProdKniga.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
{

}
