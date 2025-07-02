package com.thc.sprbasic2025summer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DefaultPageController {

    //RequestMapping 안에 주소 값은 배열도 가능합니다!!
    @RequestMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }
    /*
    @RequestMapping("/")
    public String index2(){
        return "index";
    }
    @RequestMapping("/index")
    public String index3(){
        return "index";
    }*/

    @RequestMapping("/aaa")
    public String aaa(@RequestParam String name, String phone, Model model){
        System.out.println("name : " + name);
        System.out.println("phone : " + phone);
        model.addAttribute("name", name);
        model.addAttribute("phone", "phone");
        return "aaa";
    }

    // 두개의 숫자를 입력받아, 더해주는 페이지 컨트롤러 만들기.
    // 더한 결과를 모델에 담아서, 페이지에서 값을 확인하도록 한다.
    @RequestMapping("/calculate")
    public String calculate(String num1, String num2, Model model){
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);
        int int_num1 = Integer.parseInt(num1);
        int int_num2 = Integer.parseInt(num2);
        int sum = int_num1 + int_num2;

        model.addAttribute("sum", sum);
        return "calculate";
    }
    @RequestMapping("/calculate2")
    public String calculate2(int num1, int num2, Model model){
        int sum = num1 + num2;
        model.addAttribute("sum", sum);
        /*
        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("sum", sum);
        temp.put("code", "success");
        model.addAttribute("result", temp);
        */
        return "calculate";
    }

}
