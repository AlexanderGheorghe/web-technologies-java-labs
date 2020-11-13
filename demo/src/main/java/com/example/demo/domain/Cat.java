package com.example.demo.domain;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    private int id;
    private String color;
    private String breed;
    private int age;
}
