package com.demo.controller;

import com.demo.service.DemoService;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Controller
@RequestMapping("home")
public class ViewController {

    private Map<String, SseEmitter> sseEmitters = new ConcurrentHashMap<>();

    @Autowired
    private DemoService demoService;

    @RequestMapping("view")
    public String hello(Model model) {
        return "index";
    }

}
