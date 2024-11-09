package com.nineleaps.hotel.HotelService.Repositories;

import com.nineleaps.hotel.HotelService.Models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,String> {
}
