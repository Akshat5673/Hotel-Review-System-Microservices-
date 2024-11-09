package com.nineleaps.user.UserService;

import com.nineleaps.user.UserService.External.Services.RatingService;
import com.nineleaps.user.UserService.Models.Hotel;
import com.nineleaps.user.UserService.Models.Rating;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}

//	@Test
//	void createRating(){
//		Rating rating = Rating.builder()
//				.ratingValue(5)
//				.userId("23")
//				.hotelId("345")
//				.feedback("created using feign client")
//				.hotel(new Hotel())
//				.build();
//		Rating savedRating = ratingService.createRating(rating);
//
//		log.info(String.valueOf(savedRating));
//	}


}
