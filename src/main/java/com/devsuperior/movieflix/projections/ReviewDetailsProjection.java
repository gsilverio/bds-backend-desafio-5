package com.devsuperior.movieflix.projections;

import org.springframework.beans.factory.annotation.Value;

public interface ReviewDetailsProjection {
    @Value("#{target.id}")
    Long getId();
    String getText();
    @Value("#{target.movie_id}")
    Long getMovieId();
    @Value("#{target.userId}")
    Long getUserId();
    @Value("#{target.name}")
    String getUserName();

    @Value("#{target.email}")
    String getUserEmail();


}