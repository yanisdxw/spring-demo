package com.demo.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class DemoService {

    @SneakyThrows
    public void save(SseEmitter sseEmitter, String guid){
        for (int i = 0; i < 100; i++) {
            sseEmitter.send(SseEmitter.event().name(guid).data(i));
        }
    }

}
