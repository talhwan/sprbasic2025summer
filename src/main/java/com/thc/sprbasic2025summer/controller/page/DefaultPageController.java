package com.thc.sprbasic2025summer.controller.page;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

@RequestMapping("")
@Controller
public class DefaultPageController {

    //RequestMapping 안에 주소 값은 배열도 가능합니다!!
    @GetMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }

    @ResponseBody
    @RequestMapping(value = "/image/{file:.+}", method = {RequestMethod.GET,RequestMethod.POST})
    public byte[] getImage(@PathVariable("file") String file, HttpServletRequest request) throws Exception {
        byte[] return_byte = null;
        //해당 이미지를 byte[]형태로 반환
        File tempFile = new File("C:/workspace/uploadfiles/sprbasic2025summer/" + file);
        InputStream in = null;
        try {
            in = new FileInputStream(tempFile);
            return_byte = IOUtils.toByteArray(in);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
        }
        return return_byte;
    }
    @ResponseBody
    @RequestMapping(value = "/download/{file:.+}", method = RequestMethod.GET)
    public void download(@PathVariable("file") String file, @RequestParam Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws IOException {
        File tempFile = new File("C:/workspace/uploadfiles/sprbasic2025summer/" + file);
        String fileName = URLEncoder.encode(tempFile.getName(), "utf-8");
        fileName = fileName.substring(fileName.indexOf("_") + 1);


        //여기는 response 에 설정해주는 부분인데, 어려우면 당분간은 패쓰!!
        String mimeType= URLConnection.guessContentTypeFromName(file);		//--- 파일의 mime타입을 확인합니다.
        if(mimeType==null){			//--- 마임타입이 없을 경우 application/octet-stream으로 설정합니다.
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);	//--- response에 mimetype을 설정합니다.
        response.setContentLength((int) tempFile.length());
        response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName +"\"");
        //

        InputStream inputStream = new BufferedInputStream(new FileInputStream(tempFile));	//--- inputstream 객체를 얻습니다.
        FileCopyUtils.copy(inputStream, response.getOutputStream());		//--- inputstream으로 파일을 읽고 outputsream으로 파일을 씁니다.
    }

}
