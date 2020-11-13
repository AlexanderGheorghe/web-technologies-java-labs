package com.example.demo.mapper;

import com.example.demo.domain.Cat;
import com.example.demo.dto.CatDto;
import org.springframework.stereotype.Component;

@Component
public class CatMapper {
    public CatDto Dto(Cat cat) {
        return new CatDto(cat);
    }
}
