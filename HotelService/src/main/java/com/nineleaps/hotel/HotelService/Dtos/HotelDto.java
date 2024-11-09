package com.nineleaps.hotel.HotelService.Dtos;

import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class HotelDto {

    private String hotelId;
    @Size(min = 3, message = "Name must be of minimum 3 letters !")
    private String hotelName;
    @Size(min = 3, message = "Location must be of minimum 3 letters !")
    private String location;
    @Size(max = 600, message = "About cannot be more than 600 words !")
    private String about;
}
