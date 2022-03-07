package com.demo.malfakeapi.controller;

import com.demo.malfakeapi.dto.AnimeDto;
import com.demo.malfakeapi.dto.MangaDto;
import com.demo.malfakeapi.entity.AnimeEntity;
import com.demo.malfakeapi.entity.MangaEntity;
import com.demo.malfakeapi.exception.DataException;
import com.demo.malfakeapi.response.BaseResponse;
import com.demo.malfakeapi.service.AnimeService;
import com.demo.malfakeapi.service.MangaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("animes")
public class AnimeController {
    private final AnimeService animeService;

    @GetMapping
    public List<AnimeDto> getAllAnimes(){
        return animeService.getAll();
    }

    @PostMapping
    public BaseResponse<AnimeDto> add(@RequestBody AnimeDto anime){
        return BaseResponse.<AnimeDto>builder()
                .httpCode(200)
                .message("OK")
                .response(animeService.addAnime(anime))
                .build();
    }

    @GetMapping("/{id}")
    public AnimeDto getAnimeById(@PathVariable("id") Integer id) {
        return animeService.getById(id);
    }

    @PutMapping("/{id}")
    public BaseResponse<AnimeDto> update(@RequestBody AnimeDto anime, @PathVariable("id") Integer id)
            throws DataException {
        return BaseResponse.<AnimeDto>builder()
                .httpCode(200)
                .message("OK")
                .response(animeService.updateAnime(anime, id))
                .build();
    }

    @DeleteMapping("/{id}")
    public BaseResponse<String> delete(@PathVariable("id") Integer id){
        return BaseResponse.<String>builder()
                .httpCode(200)
                .message(animeService.deleteAnime(id))
                .response("deleted")
                .build();
    }

}
