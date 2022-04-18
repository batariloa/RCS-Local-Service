package com.example.localserviceboot.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {

    public static String getUsername() throws IOException {

        String usernameString ="";

        //to load application's properties, we use this class
        Properties mainProperties = new Properties();

        FileInputStream file;

        //the base folder is ./, the root of the main.properties file
        String path = "./main.properties";

        //load the file handle for main.properties
        file = new FileInputStream(path);

        //load all the properties from this file
        mainProperties.load(file);

        //we have loaded the properties, so close the file handle
        file.close();
        usernameString = mainProperties.getProperty("username");

        return usernameString;
    }
}
