package com.example.demo.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.Transport;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 加载ES配置
 *
 * @author liuhy
 * @create 2019-08-01 17:08
 **/
@Configuration
public class ESConfig {
    @Value("${elasticsearch.cluster-nodes}")
    private String esHosts;
    @Value("${elasticsearch.cluster-name}")
    private String esName;
    @Value("${elasticsearch.port}")
    private int esPort;


    @Bean
    public TransportClient client() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", esName).build();
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        String[] hosts = esHosts.split(",");
        TransportAddress transportAddress = null;
        for (String esHost :
                hosts) {
            transportAddress = new InetSocketTransportAddress(InetAddress.getByName(esHost), esPort);
            transportClient.addTransportAddress(transportAddress);
        }
        return transportClient;
    }


}
