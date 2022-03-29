package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class ViewController {

    @RequestMapping("view")
    public String hello(Model model) {
        return "index";
    }

}
