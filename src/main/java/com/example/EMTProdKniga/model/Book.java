package com.example.EMTProdKniga.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Book
{
    @Id
    private Long id;
    private String name;
    @NotNull
    @Min(value=0)
    private Long copies;

    @ManyToOne
    private Category category;

    public Book()
    {

    }

    public Book(Long id, String name, Long copies, Long catId)
    {
        this.id = id;
        this.name = name;
        this.copies = copies;
        this.category= new Category(catId,"","");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCopies() {
        return copies;
    }

    public void setCopies(Long copies) {
        this.copies = copies;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
