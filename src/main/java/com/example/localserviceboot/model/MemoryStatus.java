package com.example.localserviceboot.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.File;


@Data
public class MemoryStatus {

    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private long diskSpaceUsable;
    private long diskSpaceTotal;


    public MemoryStatus(String status) {
        this.status = status;
        this.diskSpaceUsable = new File("/").getUsableSpace() / 1024 / 1024 / 1024;
        this.diskSpaceTotal =  new File("/").getTotalSpace() / 1024 / 1024 / 1024;


    }





}
