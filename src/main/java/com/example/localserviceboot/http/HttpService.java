package com.example.localserviceboot.http;

import com.example.localserviceboot.adapter.LocalDateAdapter;
import com.example.localserviceboot.model.LoggedAccess;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

public class HttpService {

    static HttpURLConnection connection;

     Gson gson;

    public  boolean httpRequest(String username, String serverURL) throws IOException {

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        String jsonInputString = gson.toJson(new LoggedAccess(username));

        System.out.println("SERVER URL JE " + serverURL);
        URL url = new URL(serverURL + "/status");
        connection =  (HttpURLConnection) url.openConnection();
// Now it's "open", we can set the request method, headers etc.
        connection.setRequestMethod("POST");
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        System.out.println(jsonInputString);
        DataOutputStream wr = new DataOutputStream (
                connection.getOutputStream());
        wr.writeBytes(jsonInputString);
        wr.close();
// This line makes the request
        connection.getInputStream();

        return  true;

    }






    }

