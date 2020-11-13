package com.example.demo.dto;

import com.example.demo.domain.Cat;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CatDto {

    private int id;

    @NotNull
    @Size(min=3, max=64)
    @Pattern(regexp = "^([a-z]+ ?)+$")
    private String color;

    @NotNull
    @Size(min=3, max=64)
    @Pattern(regexp = "^([A-Z][a-z]+ ?)+$")
    private String breed;

    @NotNull
    @Min(0)
    private int age;

    public CatDto(@org.jetbrains.annotations.NotNull Cat cat) {
        this(cat.getId(), cat.getColor(), cat.getBreed(), cat.getAge());
    }
}
