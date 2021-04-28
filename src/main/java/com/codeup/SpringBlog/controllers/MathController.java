package com.codeup.SpringBlog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{one}/and/{two}")
    @ResponseBody
    public int add(@PathVariable short one, @PathVariable short two) {
        return one + two;
    }

    @GetMapping("/subtract/{one}/and/{two}")
    @ResponseBody
    public int subtract(@PathVariable short one, @PathVariable short two) {
        return one - two;
    }

    @GetMapping("/multiply/{one}/and/{two}")
    @ResponseBody
    public int multiply(@PathVariable short one, @PathVariable short two) {
        return one * two;
    }

    @GetMapping("/divide/{one}/and/{two}")
    @ResponseBody
    public int divide(@PathVariable short one, @PathVariable short two) {
        return one / two;
    }
}
