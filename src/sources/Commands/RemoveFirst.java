package Commands;

import Client.Client;
import Server.Receiver;

public class RemoveFirst extends AbstractCommand{
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "удалить первый элемент из коллекции";
    public RemoveFirst(Client client, Receiver receiver) {
        super("removeFirst", client, receiver);
    }

    @Override
    public void execute() {
        receiver.removeFirst();
    }
}
