package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author liuhy
 * @create 2019-08-01 17:57
 **/
public interface ESservice {
    ResponseEntity<String> insert(List<Book> books) throws IOException;
    ResponseEntity<String> delete(String id);
}
