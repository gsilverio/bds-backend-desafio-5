package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieDetailsProjection;
import com.devsuperior.movieflix.projections.ReviewDetailsProjection;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;
    @Autowired
    private ReviewRepository reviewRepository;


    @Transactional(readOnly = true)
    public MovieDetailsDTO findById(Long id){
        Optional<Movie> movie = repository.findById(id);
        Movie entity = movie.orElseThrow(()->new ResourceNotFoundException("Entity not found"));
        return new MovieDetailsDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<MovieCardDTO> findAll(Long genreId, Pageable pageable){
        Page<MovieDetailsProjection> page = repository.searchMoviesByGenre(genreId, pageable);
        return page.map(pag->new MovieCardDTO(pag));
    }

    @Transactional(readOnly = true)
    public List<ReviewDTO> findReviewsByMovieId(Long movieId){
        List<ReviewDetailsProjection> list = reviewRepository.searchReviews(movieId);
        return list.stream().map(mov->new ReviewDTO(mov)).toList();
    }

}
