package Commands;

import Client.Client;
import Server.Receiver;

public class Clear extends AbstractCommand{
    public final static int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "очистить коллекцию";
    public Clear(Client client, Receiver receiver) {
        super("clear", client, receiver);
    }

    @Override
    public void execute() {
        receiver.clear();
    }
}
