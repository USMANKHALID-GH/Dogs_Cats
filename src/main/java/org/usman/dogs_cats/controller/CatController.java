package org.usman.dogs_cats.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.usman.dogs_cats.mapper.CatMapper;
import org.usman.dogs_cats.service.CatService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/cat")
public class CatController {

    private CatService service;
    private final CatMapper mapper;
}
