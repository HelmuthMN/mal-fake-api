package com.demo.malfakeapi.controller;

import com.demo.malfakeapi.dto.AuthorDto;
import com.demo.malfakeapi.response.BaseResponse;
import com.demo.malfakeapi.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("authors")
public class AuthorController {

    private AuthorService authorService;

    @GetMapping
    public BaseResponse<List<AuthorDto>> getAllAuthors(){
        return BaseResponse.<List<AuthorDto>>builder()
                .httpCode(200)
                .message("OK")
                .response(authorService.getAllAuthors())
                .build();
    }

    @PostMapping
    public BaseResponse<AuthorDto> addAuthor(@RequestBody AuthorDto author){
        return BaseResponse.<AuthorDto>builder()
                .httpCode(201)
                .message("CREATED")
                .response(authorService.addAuthor(author))
                .build();
    }
}
