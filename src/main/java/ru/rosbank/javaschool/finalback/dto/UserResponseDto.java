package ru.rosbank.javaschool.finalback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private int id;
    private String name;
    private String username;
    private String email;

}

