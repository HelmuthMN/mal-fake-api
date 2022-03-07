package com.demo.malfakeapi.dto;

import com.demo.malfakeapi.entity.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MangaDto {

    private String name;

    private String startDate;

    private Double score;

    private String serialization;

    private String type;

    private AuthorDto author;
}
