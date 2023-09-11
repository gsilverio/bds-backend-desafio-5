package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository repository;


    @Transactional(readOnly = true)
    public List<GenreDTO> findAll(){
        List<Genre> genre = repository.findAll();
        return genre.stream().map(gen->new GenreDTO(gen)).toList();
    }


}
