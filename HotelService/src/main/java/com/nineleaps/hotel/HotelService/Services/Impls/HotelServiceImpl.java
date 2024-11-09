package com.nineleaps.hotel.HotelService.Services.Impls;

import com.nineleaps.hotel.HotelService.Dtos.HotelDto;
import com.nineleaps.hotel.HotelService.Exceptions.ResourceNotFoundException;
import com.nineleaps.hotel.HotelService.Models.Hotel;
import com.nineleaps.hotel.HotelService.Repositories.HotelRepo;
import com.nineleaps.hotel.HotelService.Services.HotelService;
import com.nineleaps.hotel.HotelService.Utils.GenericEntityDtoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepo repo;

    @Autowired
    public HotelServiceImpl(HotelRepo repo) {
        this.repo = repo;
    }

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel = GenericEntityDtoAdapter.toEntityObject(hotelDto,Hotel.class);
        hotel.setHotelId(UUID.randomUUID().toString());
        Hotel newHotel = repo.save(hotel);
        return GenericEntityDtoAdapter.toDtoObject(newHotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(String hotelId) {
        Hotel hotel = repo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel","id",hotelId));
        return GenericEntityDtoAdapter.toDtoObject(hotel, HotelDto.class);
    }

    @Override
    public List<HotelDto> getAllHotels() {
        List<Hotel> hotelList = repo.findAll();
        return GenericEntityDtoAdapter.toDtoList(hotelList, HotelDto.class);
    }

    @Override
    public void deleteHotel(String hotelId) {
        Hotel hotel= repo.findById(hotelId)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel","id", hotelId));
        repo.delete(hotel);
    }
}
