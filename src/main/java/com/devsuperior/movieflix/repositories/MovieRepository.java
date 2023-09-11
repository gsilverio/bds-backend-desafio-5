package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieDetailsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = """    
    SELECT tb_movie.id, tb_movie.title, tb_movie.sub_title, tb_movie.movie_year, tb_movie.img_url
    FROM tb_movie
    WHERE (:genreId=0 OR tb_movie.genre_id = :genreId)
    """)
    Page<MovieDetailsProjection>searchMoviesByGenre(Long genreId, Pageable pageable);

}
