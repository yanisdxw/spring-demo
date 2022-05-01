package com.dxw.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Arrays;
import java.util.Comparator;

@Service
public class DemoService {

    @SneakyThrows
    public void save(SseEmitter sseEmitter, String guid){
        for (int i = 0; i < 100; i++) {
            sseEmitter.send(SseEmitter.event().name(guid).data(i));
        }
        int[][] a = new int[][]{{0,1}};
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
    }

}
