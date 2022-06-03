package com.example.localserviceboot.kafka;

import com.example.localserviceboot.model.Command;
import com.example.localserviceboot.utility.CommandHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @Value("${my.username}")
    private  String username;

    @KafkaListener(topics ="commands",
            containerFactory="userKafkaListenerContainerFactory")
    void listener(Command command){


        if(command.getUsername().equals(username))
        CommandHandler.handleCommand(command);
        System.out.println("Recieved " + command);
    }
}
