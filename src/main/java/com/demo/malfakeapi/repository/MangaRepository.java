package com.demo.malfakeapi.repository;

import com.demo.malfakeapi.entity.AnimeEntity;
import com.demo.malfakeapi.entity.MangaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MangaRepository extends JpaRepository<MangaEntity, Integer>, JpaSpecificationExecutor<MangaEntity> {

}
