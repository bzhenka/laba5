package Commands;

import Client.Client;
import Server.Receiver;

public class ExecuteScript extends AbstractCommand{
    public static final int ARGS_LENGTH = 1;
    public static final String DESCRIPTION = "читать и исполнить скрипт из указанного файла";
    private final String filepath;
    public ExecuteScript(Client client, Receiver receiver, String filepath) {
        super("executeScript", client, receiver);
        this.filepath = filepath;
    }

    @Override
    public void execute() {
        client.executeScript(filepath);
    }
}
