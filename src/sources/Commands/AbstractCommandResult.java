package Commands;

import Client.Client;
import Server.Receiver;

public abstract class AbstractCommandResult<T> extends AbstractCommand implements CommandWithResult<T> {
    protected T result;

    public AbstractCommandResult(String name, Client client, Receiver receiver) {
        super(name, client, receiver);
    }
}
