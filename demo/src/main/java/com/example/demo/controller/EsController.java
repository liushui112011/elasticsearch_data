package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Book;
import com.example.demo.service.impl.ESserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author liuhy
 * @create 2019-08-01 18:34
 **/
@RestController
@RequestMapping("/book")
public class EsController {

    @Autowired
    private ESserviceImpl eSservice;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> insertBook(@RequestBody  JSONArray books) {
        ArrayList<Book> bookList = new ArrayList<>();
        Book book = null;
        ResponseEntity<String> responseEntity = null;
        System.out.println(books.size());
        if (books != null && !books.isEmpty()) {
            for (int i = 0; i < books.size(); i++) {
                JSONObject bookJson = books.getJSONObject(i);;
                book = JSONObject.parseObject(bookJson.toJSONString(), Book.class);
                bookList.add(book);
            }
            responseEntity = eSservice.insert(bookList);
        } else {
            responseEntity = new ResponseEntity<String>("参数为空", HttpStatus.EXPECTATION_FAILED);
        }

        return responseEntity;
    }
}
