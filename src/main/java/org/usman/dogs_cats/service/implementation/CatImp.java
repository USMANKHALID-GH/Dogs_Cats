package org.usman.dogs_cats.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.usman.dogs_cats.repository.CatRepository;
import org.usman.dogs_cats.service.CatService;


@Service
@RequiredArgsConstructor
@Slf4j
public class CatImp implements CatService {

    private CatRepository catRepository;
}
