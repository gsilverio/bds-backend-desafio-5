package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;

public class GenreDTO {

    private Long id;
    private String name;

    public GenreDTO(Genre gen) {
        this.id= gen.getId();
        this.name = gen.getName();

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
}
