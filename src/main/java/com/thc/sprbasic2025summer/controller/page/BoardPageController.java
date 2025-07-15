package com.thc.sprbasic2025summer.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardPageController {
    /*
    @RequestMapping("/create")
    public String create() {
        return "board/create";
    }
    */

    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return "board/"+page;
    }
}
