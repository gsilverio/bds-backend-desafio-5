package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.projections.ReviewDetailsProjection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReviewDTO {

    private Long id;

	@NotBlank(message = "Campo requerido")
    private String text;

    @NotNull(message = "Campo requerido")
    private Long movieId;    
    
    private Long userId;
    private String userName;
    private String userEmail;

	public ReviewDTO(){
	}

	public ReviewDTO(ReviewDetailsProjection entity){
		this.id=entity.getId();
		this.text= entity.getText();
		this.movieId = entity.getMovieId();
		this.userId = entity.getUserId();
		this.userName = entity.getUserName();
		this.userEmail = entity.getUserEmail();
	}
	public ReviewDTO(Review reviewEntity) {
		this.id = reviewEntity.getId();
		this.text = reviewEntity.getText();
		this.movieId = reviewEntity.getMovie().getId();
		this.userId = reviewEntity.getUser().getId();
		this.userName = reviewEntity.getUser().getName();
		this.userEmail = reviewEntity.getUser().getEmail();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
