package com.example.localserviceboot;

import com.example.localserviceboot.http.HttpService;
import com.example.localserviceboot.model.LoggedAccess;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;



@SpringBootApplication
public class LocalServiceBootApplication {




    public static void main(String[] args) {


        LoggedAccess access = new LoggedAccess("dre");
        try {
            HttpService http = new HttpService();
            http.httpRequest("dre","http://localhost:8079");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SpringApplication.run(LocalServiceBootApplication.class, args);

    }


}
