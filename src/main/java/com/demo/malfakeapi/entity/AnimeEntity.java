package com.demo.malfakeapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "ANIME")
@NoArgsConstructor
@AllArgsConstructor
public class AnimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "SCORE")
    private String score;

    @Column(name = "STUDIO")
    private String studio;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DIRECTOR")
    private String director;
}
