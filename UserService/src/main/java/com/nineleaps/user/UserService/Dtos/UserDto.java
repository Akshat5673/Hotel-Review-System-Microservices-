package com.nineleaps.user.UserService.Dtos;

import com.nineleaps.user.UserService.Models.Rating;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {

    private String userId;
    @NotEmpty
    @Size(min = 3, message = "Name must be of minimum 3 letters !")
    private String name;
    @NotEmpty
    @Email(message = "Email is Invalid !")
    private String email;
    @Size(max = 600, message = "About cannot be more than 600 words !")
    private String about;
    private List<Rating> ratings = new ArrayList<>();
}
