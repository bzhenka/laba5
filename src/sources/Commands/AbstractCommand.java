package Commands;

import Client.Client;
import Server.Receiver;

public abstract class AbstractCommand implements Command {
    final protected String name;
    public final static int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "Abstract command";
    final protected Client client;
    final protected Receiver receiver;

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
