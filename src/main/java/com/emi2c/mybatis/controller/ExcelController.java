package com.emi2c.mybatis.controller;

import com.emi2c.mybatis.entity.Diary;
import com.emi2c.mybatis.excel.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ExcelController {

    @ResponseBody
    @RequestMapping(value = "/readExcel", method = RequestMethod.GET)
    public void readExcel(@RequestParam(value = "file") MultipartFile file) {
        List<Diary> diaryList = ExcelUtil.readExcel(Diary.class, file);
        diaryList.forEach(item -> {
            System.out.println(item);
        });
    }

}
