package Commands;

import Interface.Client;
import Interface.CommandWithResult;
import Server.Receiver;

public abstract class AbstractCommandResult<T> extends AbstractCommand implements CommandWithResult {
    protected AbstractCommandResult(String name, Client client, Receiver receiver) {
        super(name, client, receiver);
    }
}
