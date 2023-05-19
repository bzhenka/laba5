package Commands;

import Client.Client;
import Server.Receiver;

public class UpdateId extends AbstractCommand{
    public static final int ARGS_LENGTH = 1;
    public static final String DESCRIPTION = "обновить значение элемента коллекции, id которого равен заданному";
    int id;
    String[] movieArguments;
    public UpdateId(Client client, Receiver receiver, int id, String[] movieArguments) {
        super("updateId", client, receiver);
    }

    @Override
    public void execute() {
        receiver.updateId(id, movieArguments);
    }
}
