package com.thc.sprbasic2025summer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DefaultRestController {

    @RequestMapping("/api/calculate")
    public Map<String, Object> calculate(int a, int b){
        Map<String, Object> map = new HashMap<>();
        map.put("sum", a + b);
        return map;
    }
}
