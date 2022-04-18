package com.example.localserviceboot.utility;




import java.io.IOException;

public class ScriptService {

    public static void shutDownNow(){

        runInTerminal("shutdown now");
    }

    public static void monkey(){
        runInTerminal("xdg-open   www.google.com");
    }


    public static void commandTorrent(String link)  {

        runInTerminal("aria2c -d ../TorrentsRMS/ '" +link+"' ");
    }

    public static void runInTerminal(String cmd){


        ProcessBuilder pb = new ProcessBuilder("bash", "-c", cmd);

        try {
             pb.start();
        } catch (IOException  ex) {
            System.out.println("Cannot launch message box process");
            ex.printStackTrace();

        }



    }

    public static void openLink(String path){




        String operatingSystem = System.getProperty("os.name");
        try{
            if(operatingSystem.toLowerCase().contains("windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c",path);
                pb.start();

            } else if (operatingSystem.toLowerCase().contains("linux")){
                ProcessBuilder pb = new ProcessBuilder("bash", "-c","xdg-open",path);
                pb.start();

            } else {
                throw new UnsupportedOperationException(String.format("Not supported for %1$1s", operatingSystem));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



}

