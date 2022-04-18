package com.example.localserviceboot.http;


import com.example.localserviceboot.model.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private List<Command> commands;
    private String timestamp;
    private String status;

}
