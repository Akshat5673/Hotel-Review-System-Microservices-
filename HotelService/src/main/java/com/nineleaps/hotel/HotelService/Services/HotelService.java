package com.nineleaps.hotel.HotelService.Services;

import com.nineleaps.hotel.HotelService.Dtos.HotelDto;

import java.util.List;

public interface HotelService {

    HotelDto createHotel(HotelDto hotelDto);

    HotelDto getHotelById(String hotelId);

    List<HotelDto> getAllHotels();

    void deleteHotel(String hotelId);


}
