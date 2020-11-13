package com.example.demo.repository;

import com.example.demo.domain.Cat;
import com.example.demo.dto.CatDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CatRepository {
    private final Map<Integer, Cat> cats = new HashMap<>();
    private int id = 0;
    private final Cat catNotFound = new Cat(404, "*.%&;#^@", "not found", -1);

    public Map<Integer, Cat> getCats() { return cats; }

    public Cat getCat(int id) {
        return cats.getOrDefault(id, catNotFound);
    }

    public void add(CatDto cat) {
        cats.put(id, new Cat(id, cat.getColor(), cat.getBreed(), cat.getAge()));
        id++;
    }

    public void update(CatDto cat) {
        Cat c = cats.get(cat.getId());
        c.setAge(cat.getAge());
        c.setBreed(cat.getBreed());
        c.setColor(cat.getColor());
    }

    public void give(int id) {
        cats.remove(id);
    }
}
