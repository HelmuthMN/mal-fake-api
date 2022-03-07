package com.demo.malfakeapi.mapper;

import com.demo.malfakeapi.dto.AnimeDto;
import com.demo.malfakeapi.entity.AnimeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnimeMapper {

    AnimeMapper INSTANCE = Mappers.getMapper( AnimeMapper.class );

    List<AnimeDto> toDtoList(List<AnimeEntity> productEntityList);

    AnimeEntity toEntity(AnimeDto dto);

    AnimeDto toDto(AnimeEntity entity);
}