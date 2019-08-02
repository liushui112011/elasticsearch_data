package com.example.demo;

import com.example.demo.config.ESConfig;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.UnknownHostException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private ESConfig esConfig;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getTransPortClient() throws UnknownHostException {
        TransportClient transPort = esConfig.client();
        System.out.println(transPort);
    }


}
