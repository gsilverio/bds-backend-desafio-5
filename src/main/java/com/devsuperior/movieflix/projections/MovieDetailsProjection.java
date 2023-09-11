package com.devsuperior.movieflix.projections;

import org.springframework.beans.factory.annotation.Value;

public interface MovieDetailsProjection {

	Long getId();
	String getTitle();

	@Value("#{target.sub_title}")
	String getSubTitle();
	@Value("#{target.movie_year}")
	Integer getYear();
	@Value("#{target.img_url}")
	String getImgUrl();

}
