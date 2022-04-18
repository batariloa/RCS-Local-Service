package com.example.localserviceboot.model;


import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Objects;

@SuppressWarnings("FieldCanBeLocal")
public class Location {


//this structured is designed to fit our database
    private String ip;
    private Country country;


    public Location(){
        try {
            this.ip = getPublicIP();
            this.country = new Country(getCountryName(this.ip));
        } catch (IOException e) {
            this.ip = "unknown";
            this.country = new Country("unknown");
            e.printStackTrace();
        }
    }


    //getting our public IP from www.myip.com
    public static String getPublicIP() throws IOException {
        Document doc = Jsoup.connect("https://www.myip.com/").get();



        if(doc.getElementById("ip")!=null)
        return Objects.requireNonNull(doc.getElementById("ip")).text();

        return "no-ip";
    }

    //We are getting the country name from ip-api.com
    public static String getCountryName(String ip) throws IOException {


        String json = Jsoup.connect("http://ip-api.com/json/"+ ip).ignoreContentType(true).execute().body();

        System.out.println("JSON JE "+ json);
        JSONObject jsonObject = new JSONObject(json);

        String location = jsonObject.getString("country");


        if(location!=null)
        return location;

        return "unknown";
    }


}
