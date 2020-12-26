package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class DemoApplication {

//    @Value("${netty.port}")
//    private int port;
//
//    @Value("${netty.url}")
//    private String url;
//
//    @Autowired
//    private NettyServer server;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
//    @Override
//    public void run(String... args) throws Exception {
//        InetSocketAddress address = new InetSocketAddress(url,port);
//        System.out.println("run  .... . ... "+url);
//        server.start(address);
//    }
}

