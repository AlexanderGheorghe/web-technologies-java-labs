package com.example.demo.controller;

import com.example.demo.dto.CatDto;
import com.example.demo.service.CatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
@AllArgsConstructor
public class CatController {

    private final CatService service;

    @GetMapping
    public String cattery(Model model) {
        model.addAttribute("cats", service.getCats());
        return "cattery";
    }

    @GetMapping("{id}")
    public String inspection(@PathVariable int id, Model model){
        model.addAttribute("cat", service.getCat(id));
        return "inspection";
    }

    @GetMapping("/street")
    public String street(CatDto cat) { return "street"; };

    @PostMapping
    public String add(@Valid CatDto cat, BindingResult result, Model model) {
        if (result.hasErrors()) return "street";
        service.addCat(cat);
        return cattery(model);
    }

    @GetMapping("/review/{id}")
    public String review(@PathVariable int id, CatDto cat, Model model) {
        model.addAttribute("catDto", service.getCat(id));
        return "review";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @Valid CatDto cat, BindingResult result, Model model) {
        if(result.hasErrors()) return "review";
        service.updateCat(cat);
        model.addAttribute("cat", cat);
        return "inspection";
    }

    @GetMapping("/give/{id}")
    public String give(@PathVariable int id, Model model) {
        service.giveCat(id);
        return cattery(model);
    }
}
