package Commands;

import Interface.Client;
import Interface.Command;
import Server.Receiver;

public abstract class AbstractCommand implements Command {
    final String name;

    final Client client;

    final Receiver receiver;


    public AbstractCommand(String name, Client client, Receiver receiver) {
        this.name = name;
        this.client = client;
        this.receiver = receiver;
    }
    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
    public Client getClient(){
        return client;
    }


}
