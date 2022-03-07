package com.demo.malfakeapi.repository;

import com.demo.malfakeapi.entity.AuthorEntity;
import com.demo.malfakeapi.entity.MangaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

}
