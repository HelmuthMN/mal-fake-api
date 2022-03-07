package com.demo.malfakeapi.repository;

import com.demo.malfakeapi.dto.AnimeDto;
import com.demo.malfakeapi.entity.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<AnimeEntity, Integer> {

}
