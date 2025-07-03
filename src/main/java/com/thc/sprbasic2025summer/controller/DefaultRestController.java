package com.thc.sprbasic2025summer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api") //전체 메서드에 해당하는 주소값 앞에 더하는 효과!!
@RestController
public class DefaultRestController {

    @RequestMapping("/calculate") // /api/calculate 랑 똑같음!!
    public Map<String, Object> calculate(int a, int b){
        Map<String, Object> map = new HashMap<>();
        map.put("sum", a + b);
        return map;
    }
    @RequestMapping("/multiple")
    public int multiple(int a, int b){
        return a * b;
    }
}
