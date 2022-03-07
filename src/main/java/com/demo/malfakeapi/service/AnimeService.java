package com.demo.malfakeapi.service;

import com.demo.malfakeapi.dto.AnimeDto;
import com.demo.malfakeapi.dto.AuthorDto;
import com.demo.malfakeapi.entity.AnimeEntity;
import com.demo.malfakeapi.error.DataError;
import com.demo.malfakeapi.exception.DataException;
import com.demo.malfakeapi.mapper.AnimeMapper;
import com.demo.malfakeapi.mapper.AnimeMapperImpl;
import com.demo.malfakeapi.mapper.MangaMapper;
import com.demo.malfakeapi.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public List<AnimeDto> getAll() {
        List<AnimeDto> animeList = AnimeMapper.INSTANCE.toDtoList(animeRepository.findAll());
        if(animeList.size() != 0){
            return animeList;
        } else {
            throw new DataException(new DataError("NOT_FOUND",
                    HttpStatus.NOT_FOUND.value(),
                    "Unable to find any anime."));
        }
    }

    public AnimeDto getById(Integer id) throws DataException {
        if (animeRepository.existsById(id)) {
            return AnimeMapper.INSTANCE.toDto(animeRepository.getById(id));
        }else {
            throw new DataException(new DataError("NOT_FOUND",
                    HttpStatus.NOT_FOUND.value(),
                    "Unable to find the anime with this id "));
        }
    }

    public AnimeDto addAnime(AnimeDto anime){
        return AnimeMapper.INSTANCE.toDto(animeRepository.save(AnimeMapper.INSTANCE.toEntity(anime)));
    }

    public AnimeDto updateAnime(AnimeDto anime, Integer id) throws DataException {
//        Optional<AnimeEntity> animeEntity = Optional.of(animeRepository.getById(id));
        if (animeRepository.existsById(id)) {
            AnimeDto updatedAnime = AnimeMapper.INSTANCE.toDto(animeRepository.getById(id));
            updatedAnime.setName(anime.getName());
            updatedAnime.setScore(anime.getScore());
            updatedAnime.setStudio(anime.getStudio());
            updatedAnime.setStartDate(anime.getStartDate());
            updatedAnime.setType(anime.getType());
            updatedAnime.setDirector(anime.getDirector());
            return AnimeMapper.INSTANCE.toDto(animeRepository.save(AnimeMapper.INSTANCE.toEntity(updatedAnime)));
        }else {
            throw new DataException(new DataError("NOT_FOUND",
                    HttpStatus.NOT_FOUND.value(),
                    "Unable to find this anime"));
        }
    }

    public String deleteAnime(Integer id) {
        if(animeRepository.existsById(id)) {
            AnimeEntity anime = animeRepository.getById(id);
            animeRepository.delete(anime);
            return "deleted";
        }else {
            throw new DataException(new DataError("NOT_FOUND",
                    HttpStatus.NOT_FOUND.value(),
                    "Unable to find this anime"));
        }
    }
}
