package com.nineleaps.rating.RatingService.Dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    private String ratingId;
    @NotBlank
    private String userId;
    @NotBlank
    private String hotelId;
    @NotBlank
    @Size(message = "Rating cannot be less than 0 !")
    private Integer ratingValue;
    @Size(max = 500, message = "Feedback cannot be more than 500 words !")
    private String feedback;

}
