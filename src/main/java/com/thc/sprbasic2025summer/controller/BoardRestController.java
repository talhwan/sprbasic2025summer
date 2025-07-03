package com.thc.sprbasic2025summer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    List<Map<String, Object>> list = new ArrayList<>();
    int tempId = 0;

    //수업 시간 천천히 진행
    @RequestMapping("/create")
    public Map<String, Object> create(
            //@RequestParam String title, String content, String author
            @RequestParam Map<String, Object> param
    ){
        String title = param.get("title").toString();
        String content = param.get("content").toString();
        String author = param.get("author").toString();
        /*System.out.println(title);
        System.out.println(content);
        System.out.println(author);*/
        Map<String,Object> map_board = new HashMap<>();
        map_board.put("id", ++tempId);
        map_board.put("title", title);
        map_board.put("content", content);
        map_board.put("author", author);
        list.add(map_board);

        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        map_result.put("totalsize", list.size());
        return map_result;
    }

    //수업 시간 눈으로만 검토
    @RequestMapping("/update")
    public Map<String, Object> update(
            @RequestParam Map<String, Object> param
    ){
        int code = 0;
        int id = Integer.parseInt(param.get("id").toString());
        String title = param.get("title").toString();
        String content = param.get("content").toString();
        String author = param.get("author").toString();

        Map<String,Object> map_board = getData(id);
        if(map_board != null){
            map_board.put("title", title);
            map_board.put("content", content);
            map_board.put("author", author);
            code = 200;
        }
        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", code);
        return map_result;
    }
    //수업 시간 눈으로만 검토
    @RequestMapping("/delete")
    public Map<String, Object> delete(
            @RequestParam Map<String, Object> param
    ){
        int code = 0;
        int id = Integer.parseInt(param.get("id").toString());

        int tempI=-1;
        for(int i=0;i<list.size();i++){
            int eachId = Integer.parseInt(list.get(i).get("id").toString());
            if(eachId == id){
                tempI = i;
            }
        }
        if(tempI != -1){
            list.remove(tempI);
            code = 200;
        }

        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", code);
        return map_result;
    }
    //수업 시간 눈으로만 검토
    @RequestMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id){
        Map<String,Object> map_board = getData(id);
        int resultCode = 0;
        if(map_board != null){
            resultCode = 200;
        }
        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", resultCode);
        map_result.put("board", map_board);
        return map_result;
    }

    public Map<String,Object> getData(int id){
        Map<String,Object> map_board = null;
        for(Map<String, Object> each : list){
            int eachId = Integer.parseInt(each.get("id").toString());
            if(eachId == id){
                map_board = each;
            }
        }
        return map_board;
    }

    //수업 시간 천천히 진행
    @RequestMapping("/list")
    public Map<String, Object> list(){
        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        map_result.put("totalsize", list.size());
        map_result.put("list", list);
        return map_result;
    }


}
