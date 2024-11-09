package com.nineleaps.user.UserService.Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private Integer ratingValue;
    private String feedback;
    private Hotel hotel;

}
