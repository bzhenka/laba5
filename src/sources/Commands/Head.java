package Commands;

import Client.Client;
import Models.Movie;
import Server.Receiver;

public class Head extends AbstractCommandResult<Movie> {
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "вывести первый элемент коллекции";

    public Head(Client client, Receiver receiver) {
        super("head", client, receiver);
    }

    @Override
    public void execute() {
        result = receiver.head();
    }

    @Override
    public Movie getResult() {
        return result;
    }
}
