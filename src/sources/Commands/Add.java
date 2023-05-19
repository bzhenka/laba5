package Commands;

import Client.Client;
import Server.Receiver;

public class Add extends AbstractCommand{
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION ="добавить новый элемент в коллекцию";
    private final String[] movieArguments;
//

    public Add(Client client, Receiver receiver, String[] movieArguments) {
        super("add", client, receiver);
        this.movieArguments = movieArguments;
    }

    @Override
    public void execute() {
        receiver.add(movieArguments);
    }
}
