package com.demo.malfakeapi.service;

import com.demo.malfakeapi.dto.MangaDto;
import com.demo.malfakeapi.entity.MangaEntity;
import com.demo.malfakeapi.error.DataError;
import com.demo.malfakeapi.exception.DataException;
import com.demo.malfakeapi.mapper.AuthorMapper;
import com.demo.malfakeapi.mapper.MangaMapper;
import com.demo.malfakeapi.repository.MangaRepository;
import com.demo.malfakeapi.specification.MangaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    public List<MangaDto> getAll() {
        List<MangaEntity> mangaEntityList = mangaRepository.findAll();

        if(mangaEntityList.size() != 0){
            return MangaMapper.INSTANCE.toDtoList(mangaEntityList);
        }else{
            throw new DataException(new DataError("NOT_FOUND",
                    HttpStatus.NOT_FOUND.value(),
                    "Unable to find mangas with this criteria!"));
        }
    }

    public MangaDto getById(Integer id) {
        if (mangaRepository.existsById(id)){
            return MangaMapper.INSTANCE.toDto(mangaRepository.getById(id));
        }else {
            throw new DataException(new DataError("NOT_FOUND",
                HttpStatus.NOT_FOUND.value(),
                "Unable to find this manga"));
        }
    }

    public MangaDto addManga(MangaDto manga){
        return MangaMapper.INSTANCE.toDto(mangaRepository.save((MangaMapper.INSTANCE.toEntity(manga))));
    }

    public MangaDto updateManga(MangaDto manga, Integer id) {
        if (mangaRepository.existsById(id)) {
            MangaEntity updatedManga = mangaRepository.getById(id);
            updatedManga.setName(manga.getName());
            updatedManga.setScore(manga.getScore());
            updatedManga.setSerialization(manga.getSerialization());
            updatedManga.setStartDate(manga.getStartDate());
            updatedManga.setType(manga.getType());
            updatedManga.setAuthor(AuthorMapper.INSTANCE.toEntity(manga.getAuthor()));
            return MangaMapper.INSTANCE.toDto(mangaRepository.save(updatedManga));
        } else {
            throw new DataException(new DataError("NOT_FOUND",
                    HttpStatus.NOT_FOUND.value(),
                    "Unable to find this manga"));
        }
    }

    public String deleteManga(Integer id) {
        if (mangaRepository.existsById(id)) {
            MangaEntity manga = mangaRepository.getById(id);
            mangaRepository.delete(manga);
            return "deleted";
        }else {
            throw new DataException(new DataError("NOT_FOUND",
                    HttpStatus.NOT_FOUND.value(),
                    "Unable to find this manga"));
        }
    }

    public List<MangaDto> getAllMangasWithScoreGreaterThan(Double score) {
        List<MangaEntity> mangaEntityList = mangaRepository.findAll(Specification
                .where(MangaSpecification.mangaScoreGreaterThan(score)));

        if(mangaEntityList.size() != 0){
            return MangaMapper.INSTANCE.toDtoList(mangaEntityList);
        }else{
            throw new DataException(new DataError("NOT_FOUND",
                    HttpStatus.NOT_FOUND.value(),
                    "Unable to find mangas with this criteria!"));
        }
    }

    public List<MangaDto> getAllMangasWithScoreLessThan(Double score) {
        List<MangaEntity> mangaEntityList = mangaRepository.findAll(Specification
                .where(MangaSpecification.mangaScoreLessThan(score)));

        if(mangaEntityList.size() != 0){
            return MangaMapper.INSTANCE.toDtoList(mangaEntityList);
        }else{
            throw new DataException(new DataError("NOT_FOUND",
                    HttpStatus.NOT_FOUND.value(),
                    "Unable to find mangas with this criteria!"));
        }
    }
}
