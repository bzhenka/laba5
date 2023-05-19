package Commands;

import Client.Client;
import Server.Receiver;

public class RemoveById extends AbstractCommandResult<Boolean>{
    public static final int ARGS_LENGTH = 1;
    public static final String DESCRIPTION = "удалить элемент из коллекции по его id";
    private final int id;
    public RemoveById(Client client, Receiver receiver, int id) {
        super("removeById", client, receiver);
        this.id = id;
    }

    @Override
    public void execute() {
        result = receiver.removeById(id);
    }

    @Override
    public Boolean getResult() {
        return result;
    }
}
