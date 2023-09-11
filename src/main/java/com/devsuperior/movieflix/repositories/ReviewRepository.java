package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.projections.ReviewDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(nativeQuery = true, value = """
    SELECT tb_review.id, tb_review.text, tb_review.movie_id, tb_user.id as userId, tb_user.name, tb_user.email
    FROM tb_review
    INNER JOIN tb_movie ON tb_review.movie_id = tb_movie.id
    INNER JOIN tb_user ON tb_review.user_id = tb_user.id
    WHERE tb_movie.id = :movieId
    """)
    List<ReviewDetailsProjection> searchReviews(Long movieId);

}
