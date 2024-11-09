package com.nineleaps.hotel.HotelService.Controllers;

import com.nineleaps.hotel.HotelService.Dtos.HotelDto;
import com.nineleaps.hotel.HotelService.Payloads.ApiResponse;
import com.nineleaps.hotel.HotelService.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private final HotelService service;

    @Autowired
    public HotelController(HotelService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto){
        return new ResponseEntity<>(service.createHotel(hotelDto), HttpStatus.CREATED);
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<HotelDto> getHotel(@PathVariable String id){
        return ResponseEntity.ok(service.getHotelById(id));
    }

    @GetMapping("/list/")
    public ResponseEntity<List<HotelDto>> retrieveHotelList(){
        return ResponseEntity.ok(service.getAllHotels());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteHotel(@PathVariable String id){
        service.deleteHotel(id);
        return new ResponseEntity<>(new ApiResponse("Hotel Deleted Successfully",
                true,HttpStatus.OK)
                , HttpStatus.OK);
    }
}
