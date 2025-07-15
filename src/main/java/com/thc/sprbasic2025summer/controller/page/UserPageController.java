package com.thc.sprbasic2025summer.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserPageController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return "user/"+page;
    }
    @RequestMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "user/"+page;
    }
}
