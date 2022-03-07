package com.demo.malfakeapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "MANGAS")
@NoArgsConstructor
@AllArgsConstructor
public class MangaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "SCORE")
    private Double score;

    @Column(name = "SERIALIZATION")
    private String serialization;

    @Column(name = "TYPE")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID")
    private AuthorEntity author;
}