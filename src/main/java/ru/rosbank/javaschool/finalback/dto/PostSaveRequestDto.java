package ru.rosbank.javaschool.finalback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.finalback.entity.UserEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostSaveRequestDto {

    private int id;
    @NotNull
    private UserEntity author;
    @NotNull
    @Size(min = 1, message = "error.validation.min_size")
    @Size(max = 1000, message = "error.validation.max_size")
    private String content;
    private String media;

}
