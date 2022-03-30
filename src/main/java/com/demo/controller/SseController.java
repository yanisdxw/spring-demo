package com.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.UUID;
import java.util.concurrent.Executors;

@Controller
@RequestMapping("sse")
public class SseController {

    @GetMapping("get")
    public SseEmitter get(){
        SseEmitter sseEmitter = new SseEmitter();
        Executors.newSingleThreadExecutor().execute(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    EventData eventData = new EventData(i,10);
                    SseEmitter.SseEventBuilder event = SseEmitter.event()
                            .id(String.valueOf(i)).data(eventData).name("eventData");
                    sseEmitter.send(event);
                    Thread.sleep(1000);
                }
                SseEmitter.SseEventBuilder event = SseEmitter.event()
                        .id(String.valueOf(UUID.randomUUID())).data("we have finished!").name("eventResult");
                sseEmitter.send(event);
                sseEmitter.complete();
            }catch (Exception e){
                sseEmitter.completeWithError(e);
            }
        });
        return sseEmitter;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class EventData {
        Integer count;
        Integer total;
    }

}
