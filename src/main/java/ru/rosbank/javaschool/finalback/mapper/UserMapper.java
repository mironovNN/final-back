package ru.rosbank.javaschool.finalback.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.rosbank.javaschool.finalback.constants.UserConstant;
import ru.rosbank.javaschool.finalback.dto.UserProfileResponseDto;
import ru.rosbank.javaschool.finalback.dto.UserSaveRequestDto;
import ru.rosbank.javaschool.finalback.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserProfileResponseDto entityToUserProfileResponseDto(UserEntity entity);

    @Mappings({
            @Mapping(target = UserConstant.PASSWORD,
                    expression = "java(encoder.encode(dto.getPassword()))"),
            @Mapping(target = UserConstant.AUTHORITIES,
                    expression = "java((java.util.List.of(new org.springframework.security.core.authority.SimpleGrantedAuthority(\"ROLE_USER\"))))"),
            @Mapping(target = UserConstant.ACCOUNT_NON_EXPIRED, constant = "true"),
            @Mapping(target = UserConstant.ACCOUNT_NON_LOCKED, constant = "true"),
            @Mapping(target = UserConstant.CREDENTIALS_NON_EXPIRED, constant = "true"),
            @Mapping(target = UserConstant.ENABLED, constant = "true"),
    })
    UserEntity dtoToUserEntity(UserSaveRequestDto dto, PasswordEncoder encoder);

}