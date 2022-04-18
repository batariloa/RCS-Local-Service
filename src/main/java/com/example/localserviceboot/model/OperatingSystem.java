package com.example.localserviceboot.model;


@SuppressWarnings("FieldCanBeLocal")
public class OperatingSystem {

    private final String name;
    private final String architecture;
    private final String version;

    public OperatingSystem(){

        this.name = getName();
        this.architecture = getArchitecture();
        this.version = getVersion();
    }

    public String getName(){

        return  System.getProperty("os.name");

    }


    public String getArchitecture(){

        return  System.getProperty("os.arch");

    }

    public String getVersion(){

        return  System.getProperty("os.version");

    }
}
