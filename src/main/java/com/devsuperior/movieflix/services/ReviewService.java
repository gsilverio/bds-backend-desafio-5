package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private MovieRepository movieRepository;


    /*
    TESTE DE VERIFICAÇÃO DE TODOS OS REVIEWS
    @Transactional
    public List<ReviewDTO> findAll(){
        List<Review> review = repository.findAll();
        return review.stream().map(rev->new ReviewDTO(rev)).toList();
    }
    */

    @Transactional
    public ReviewDTO insert(ReviewDTO body){

        Review reviewEntity = new Review();
        copyDtoToEntity(body, reviewEntity);

        reviewEntity = repository.save(reviewEntity);
        return new ReviewDTO(reviewEntity);

    }
    private void copyDtoToEntity(ReviewDTO dto, Review entity)
    {
        entity.setText(dto.getText());

        UserDTO user = userService.getProfile();
        User userEntity = new User(user.getId(),user.getName(),user.getEmail());

        entity.setUser(userEntity);

        Movie movie = movieRepository.getReferenceById(dto.getMovieId());
        entity.setMovie(movie);

    }

}
