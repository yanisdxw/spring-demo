package com.dxw.controller;

import com.dxw.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/account")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("get")
    public String get(@RequestParam String id){
        return "hello,"+id+"!";
    }



}
