package com.demo.malfakeapi.mapper;

import com.demo.malfakeapi.dto.MangaDto;
import com.demo.malfakeapi.entity.MangaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MangaMapper {
    MangaMapper INSTANCE = Mappers.getMapper( MangaMapper.class);

    List<MangaDto> toDtoList(List<MangaEntity> entityList);

    MangaEntity toEntity(MangaDto dto);

    MangaDto toDto(MangaEntity entity);
}