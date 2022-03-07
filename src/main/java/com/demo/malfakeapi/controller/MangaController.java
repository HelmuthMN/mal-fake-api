package com.demo.malfakeapi.controller;

import com.demo.malfakeapi.dto.MangaDto;
import com.demo.malfakeapi.response.BaseResponse;
import com.demo.malfakeapi.service.MangaService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("mangas")
public class MangaController {

    private final MangaService mangaService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<MangaDto>>> getAllMangas(){
        return ResponseEntity.ok(BaseResponse.<List<MangaDto>>builder()
                .httpCode(HttpStatus.OK.value())
                .message("OK")
                .response(mangaService.getAll())
                .build());
    }

    @PostMapping
    public ResponseEntity<BaseResponse<MangaDto>> addManga(@RequestBody MangaDto manga){
        return ResponseEntity.ok(BaseResponse.<MangaDto>builder()
                .httpCode(HttpStatus.CREATED.value())
                .message("CREATED")
                .response(mangaService.addManga(manga))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<MangaDto>> getMangaById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(BaseResponse.<MangaDto>builder()
                .httpCode(HttpStatus.OK.value())
                .message("OK")
                .response(mangaService.getById(id))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<MangaDto>> updateManga(@RequestBody MangaDto manga, @PathVariable("id") Integer id){
        return ResponseEntity.ok(BaseResponse.<MangaDto>builder()
                .httpCode(HttpStatus.OK.value())
                .message("OK")
                .response(mangaService.updateManga(manga, id))
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> deleteManga(@PathVariable("id") Integer id){
        return ResponseEntity.ok(BaseResponse.<String>builder()
                .httpCode(HttpStatus.OK.value())
                .message(mangaService.deleteManga(id))
                .response("deleted")
                .build());
    }

    @GetMapping("/gt")
    public ResponseEntity<BaseResponse<List<MangaDto>>> getMangaWithScoreGreaterThan(@Param("score") Double score){
        return ResponseEntity.ok(BaseResponse.<List<MangaDto>>builder()
                .httpCode(HttpStatus.OK.value())
                .message("Mangas found")
                .response(mangaService.getAllMangasWithScoreGreaterThan(score))
                .build());
    }
    @GetMapping("/lt")
    public ResponseEntity<BaseResponse<List<MangaDto>>> getMangaWithScoreLessThan(@Param("score") Double score){
        return ResponseEntity.ok(BaseResponse.<List<MangaDto>>builder()
                .httpCode(HttpStatus.OK.value())
                .message("Mangas found")
                .response(mangaService.getAllMangasWithScoreLessThan(score))
                .build());
    }
}
