package ru.rosbank.javaschool.finalback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.finalback.constraint.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequestDto {

    private int id;
    @NotNull
    @Size(min = 2, message = "error.validation.min_size")
    private String name;
    @NotNull
    @Size(min = 2, message = "error.validation.min_size")
    private String username;
    @NotNull
    @Size(min = 4, message = "error.validation.min_size")
    private String password;
    @NotNull
    @Email(message = "error.validation.email")
    private String email;

    private String photo;

}