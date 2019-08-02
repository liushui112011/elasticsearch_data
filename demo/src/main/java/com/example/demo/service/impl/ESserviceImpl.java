package com.example.demo.service.impl;

import com.example.demo.config.ESConfig;
import com.example.demo.model.Book;
import com.example.demo.service.ESservice;
import org.apache.lucene.queryparser.flexible.core.util.StringUtils;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author liuhy
 * @create 2019-08-01 18:07
 **/
@Service
public class ESserviceImpl implements ESservice {
    @Autowired
    private ESConfig esConfig;

    @Override
    public ResponseEntity<String> insert(List<Book> books) {
        try {
            TransportClient transportClient = esConfig.client();
            for (Book book :
                    books) {
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
                        .field("id", book.getId())
                        .field("name", book.getName())
                        .field("author", book.getAuthor())
                        .endObject();

                IndexResponse response = transportClient.prepareIndex("book", "story", StringUtils.toString(book.getId()))
                        .setSource(builder).get();
                return new ResponseEntity<>(response.getId(), HttpStatus.OK);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public ResponseEntity<String> delete(String id) {
        return null;
    }
}
