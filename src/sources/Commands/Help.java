package Commands;

import Client.Client;
import Server.Receiver;

public class Help extends AbstractCommand {
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "вывести справку по доступным командам";
    public Help(Client client, Receiver receiver) {
        super("help", client, receiver);
    }

    @Override
    public void execute() {
        client.help();
    }
}
