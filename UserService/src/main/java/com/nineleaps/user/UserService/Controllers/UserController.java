package com.nineleaps.user.UserService.Controllers;

import com.nineleaps.user.UserService.Dtos.UserDto;
import com.nineleaps.user.UserService.Payloads.ApiResponse;
import com.nineleaps.user.UserService.Services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.CREATED);
    }

    int retryCount=1;
    @GetMapping("/retrieve/{id}")
 //   @Retry(name = "RATING_HOTEL_SERVICE",fallbackMethod = "ratingHotelFallback")
       @CircuitBreaker(name = "RATING_HOTEL_BREAKER",fallbackMethod = "ratingHotelFallback")
//    @RateLimiter(name = "USER_RATE_LIMITER", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<UserDto> getUser(@PathVariable String id){
//        log.info("Retry Count: {}",retryCount);
//        retryCount++;
        return ResponseEntity.ok(userService.getUser(id));
    }

    // fallback for circuit breaker

    public ResponseEntity<UserDto> ratingHotelFallback(String id, Exception ex){
        log.info("Fallback executed because of failure of one or more of the microservices: "+ex.getMessage());

        UserDto userDto = UserDto.builder()
                .userId("404")
                .name("Dummy")
                .email("dummy@gmail.com")
                .about("Dummy user displayed because of service issues.")
                .ratings(Collections.emptyList()).build();
        return new ResponseEntity<>(userDto,HttpStatus.OK);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,
                                              @PathVariable String id){
        UserDto updatedUser = userService.updateUser(id,userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("list/")
    public ResponseEntity<List<UserDto>> retrieveUserList(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully",
                true,HttpStatus.OK)
                , HttpStatus.OK);
    }

}
