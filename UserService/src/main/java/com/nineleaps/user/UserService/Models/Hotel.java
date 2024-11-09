package com.nineleaps.user.UserService.Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {
    private String hotelId;
    private String hotelName;
    private String location;
    private String about;
}
