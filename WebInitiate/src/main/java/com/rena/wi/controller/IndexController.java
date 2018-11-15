package com.rena.wi.controller;

import com.rena.wi.util.IOCloseUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;

/**
 * description 首页控制器
 *
 * @author rena
 * @date 2018/11/9 16:03
 **/

@RestController(value = "indexController")
@RequestMapping("index")
public class IndexController {

    @GetMapping("test")
    public String test(){
        return "test";
    }

    @GetMapping("index")
    //@RequestMapping(value = "index", method={RequestMethod.GET})
    public String index(){
        return "index.html";
    }

    @GetMapping("download")
    public void download(HttpServletResponse response) throws Exception {
//        URL url = IndexController.class.getClassLoader().getResource("file/com.yunva.im.sdk.lib.YvImSdkApplication.apk");
        // URL url = IndexController.class.getClassLoader().getResource("file/test");
        File file = new File("data/com.yunva.im.sdk.lib.YvImSdkApplication.apk");
        InputStream inputStream = new FileInputStream(file);
        response.setCharacterEncoding("UTF-8");
        // response.setContentType(file.getContentType());
        // Content-Disposition
        try {
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        BufferedInputStream inStream = new BufferedInputStream(inputStream);
        BufferedOutputStream outStream = null;

        try {
            outStream = new BufferedOutputStream(response.getOutputStream());
            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOCloseUtil.close(outStream);
            IOCloseUtil.close(inStream);
        }
    }
}
