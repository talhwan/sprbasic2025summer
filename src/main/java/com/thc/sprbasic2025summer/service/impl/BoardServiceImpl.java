package com.thc.sprbasic2025summer.service.impl;

import com.thc.sprbasic2025summer.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    List<Map<String, Object>> list = new ArrayList<>();
    int tempId = 0;

    @Override
    public Map<String, Object> create(Map<String, Object> param) {
        String title = param.get("title").toString();
        String content = param.get("content").toString();
        String author = param.get("author").toString();
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

    @Override
    public Map<String, Object> update(Map<String, Object> param) {
        int code = 0;
        int id = Integer.parseInt(param.get("id").toString());

        Map<String,Object> map_board = getData(id);
        if(map_board != null){
            String title = param.get("title").toString();
            String content = param.get("content").toString();
            String author = param.get("author").toString();
            map_board.put("title", title);
            map_board.put("content", content);
            map_board.put("author", author);
            code = 200;
        }
        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", code);
        return map_result;
    }

    @Override
    public Map<String, Object> delete(int id) {
        int code = 0;

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

    @Override
    public Map<String, Object> detail(int id) {
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

    @Override
    public Map<String, Object> list() {
        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        map_result.put("totalsize", list.size());
        map_result.put("list", list);
        return map_result;
    }
}
