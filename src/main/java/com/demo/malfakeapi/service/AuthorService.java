package com.demo.malfakeapi.service;

import com.demo.malfakeapi.dto.AuthorDto;
import com.demo.malfakeapi.entity.AuthorEntity;
import com.demo.malfakeapi.mapper.AuthorMapper;
import com.demo.malfakeapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDto> getAllAuthors(){
        return AuthorMapper.INSTANCE.toDtoList(authorRepository.findAll());
    }

    public AuthorDto addAuthor(AuthorDto author){
        return AuthorMapper.INSTANCE.toDto(authorRepository.save(AuthorMapper.INSTANCE.toEntity(author)));
    }
}
