package com.emi2c.mybatis.util;


import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 上传下载工具类
 */
public class FileUtil {

    public static String uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
        return filePath + fileName;
    }

    public static ResponseEntity<InputStreamResource> downloadFile(String url) throws IOException {
        FileSystemResource file = new FileSystemResource(url);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        //设置文件名并设置文件名编码，解决文件名异常问题
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", new
                String(file.getFilename().getBytes("GBK"),"ISO8859-1")));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }

}
