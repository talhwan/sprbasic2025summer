package com.thc.sprbasic2025summer.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostPageController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return "post/"+page;
    }
    @RequestMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "post/"+page;
    }
}
