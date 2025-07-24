package com.thc.sprbasic2025summer.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chat")
@Controller
public class ChatPageController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return "chat/"+page;
    }
    @RequestMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "chat/"+page;
    }
}
