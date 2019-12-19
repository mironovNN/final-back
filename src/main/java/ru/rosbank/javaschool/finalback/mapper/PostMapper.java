package ru.rosbank.javaschool.finalback.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.rosbank.javaschool.finalback.constants.PostConstant;
import ru.rosbank.javaschool.finalback.dto.PostResponseDto;
import ru.rosbank.javaschool.finalback.dto.PostSaveRequestDto;
import ru.rosbank.javaschool.finalback.entity.PostEntity;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mappings({
            @Mapping(target = "authorId", expression = "java(entity.getAuthor().getId())"),
            @Mapping(target = "authorUsername", expression = "java(entity.getAuthor().getUsername())")
    })
    PostResponseDto entityToPostResponseDto(PostEntity entity);

    @Mappings({
            @Mapping(target = PostConstant.LIKES, constant = "0"),
            @Mapping(target = PostConstant.REMOVED, constant = "false"),
            @Mapping(target = PostConstant.CREATED, expression = "java(java.time.LocalDate.now())")
    })
    PostEntity dtoToPostEntity(PostSaveRequestDto dto);

}