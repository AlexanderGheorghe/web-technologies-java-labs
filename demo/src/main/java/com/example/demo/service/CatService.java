package com.example.demo.service;

import com.example.demo.dto.CatDto;
import com.example.demo.mapper.CatMapper;
import com.example.demo.repository.CatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatService {
    private final CatRepository repository;
    private final CatMapper mapper;

    public List<CatDto> getCats() {
        return repository.getCats().values().stream().map(mapper::Dto).collect(Collectors.toList());
    }

    public CatDto getCat(int id) {
        return mapper.Dto(repository.getCat(id));
    }

    public void addCat(CatDto cat) {
        repository.add(cat);
    }

    public void updateCat(CatDto cat) {
        repository.update(cat);
    }

    public void giveCat(int id) {
        repository.give(id);
    }
}
