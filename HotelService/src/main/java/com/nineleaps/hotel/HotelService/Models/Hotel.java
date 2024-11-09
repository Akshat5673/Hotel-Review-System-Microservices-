package com.nineleaps.hotel.HotelService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "micro_hotels")
@Builder
public class Hotel {

    @Id
    private String hotelId;
    private String hotelName;
    private String location;
    private String about;
}
