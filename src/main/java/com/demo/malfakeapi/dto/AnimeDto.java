package com.demo.malfakeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimeDto {

    private String name;

    private String startDate;

    private Double score;

    private String studio;

    private String type;

    private String director;
}
