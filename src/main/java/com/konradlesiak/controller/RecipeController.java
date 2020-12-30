package com.konradlesiak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {

    @GetMapping({"", "/", "index", "index.html"})
    public String getHomePage() {
        return "index";
    }
}
