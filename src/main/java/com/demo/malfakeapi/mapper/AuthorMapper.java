package com.demo.malfakeapi.mapper;

import com.demo.malfakeapi.dto.AuthorDto;
import com.demo.malfakeapi.entity.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper( AuthorMapper.class);

    List<AuthorDto> toDtoList(List<AuthorEntity> entityList);

    AuthorEntity toEntity(AuthorDto dto);

    AuthorDto toDto(AuthorEntity entity);
}
