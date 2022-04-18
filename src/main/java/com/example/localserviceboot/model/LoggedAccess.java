package com.example.localserviceboot.model;


import java.time.LocalDateTime;
import java.time.ZoneId;

@SuppressWarnings("FieldCanBeLocal")
public class LoggedAccess {


    private final String timestamp;
    private final MemoryStatus status;
    private final String username;
    private final Location location;
    private final OperatingSystem operatingSystem;

    public LoggedAccess(String username){
// your local date/time with no timezone information
        LocalDateTime localNow = LocalDateTime.now();
//System is keeping a Netherlands timezone
        this.timestamp = localNow.atZone(ZoneId.of("GMT+2")).toLocalDateTime().toString();
        this.username = username;
        this.status = new MemoryStatus("Status is: available.");
        this.location = new Location();
        this.operatingSystem = new OperatingSystem();


    }

}
