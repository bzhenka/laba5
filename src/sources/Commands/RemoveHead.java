package Commands;

import Client.Client;
import Models.Movie;
import Server.Receiver;

public class RemoveHead extends AbstractCommandResult<Movie> {
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "вывести первый элемент коллекции и удалить его";
    public RemoveHead(Client client, Receiver receiver) {
        super("removeHead", client, receiver);
    }

    @Override
    public void execute() {
        result = receiver.removeHead();
    }

    @Override
    public Movie getResult() {
        return result;
    }
}
