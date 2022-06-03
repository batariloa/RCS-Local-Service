package com.example.localserviceboot.utility;

import com.example.localserviceboot.model.Command;

public class CommandHandler {

    public static void handleCommand(Command command){

        switch (command.getType()){

            case TERMINAL:
                ScriptService.runInTerminal(command.getCommand());
                break;

            case TORRENT:
                ScriptService.commandTorrent(command.getCommand());
                break;

            case SHUTDOWN:
                ScriptService.shutDownNow();
                break;

            case MONKEY:
                ScriptService.monkey();

                break;
        }

    }



}
