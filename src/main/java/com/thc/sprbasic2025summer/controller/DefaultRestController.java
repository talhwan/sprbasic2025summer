package com.thc.sprbasic2025summer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/default") //전체 메서드에 해당하는 주소값 앞에 더하는 효과!!
@RestController
public class DefaultRestController {

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        System.out.println("file : " + fileName);


        String tempPath = "C:/workspace/uploadfiles/sprbasic2025summer/";
        File newfile = new File(tempPath);
        // File 객체에 담긴 폴더가 존재하는지 물어봄!
        if(!newfile.exists()) {
            // File 객체에 담긴 폴더가 존재안하면 강제 생성!!
            newfile.mkdirs();
        }

        try{
            Date date = new Date();
            String temp_date = date.getTime() + "";
            FileCopyUtils.copy(file.getBytes(), new File(tempPath + temp_date + "_" + fileName));
            return ResponseEntity.ok(temp_date + "_" + fileName);
        } catch (Exception e){

        }
        return ResponseEntity.ok("");
    }
}
