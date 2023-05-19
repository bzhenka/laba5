package Commands;

import Client.Client;
import Models.Movie;
import Server.Receiver;

import java.util.ArrayDeque;

public class Show extends AbstractCommandResult<ArrayDeque<Movie>> {
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    public Show(Client client, Receiver receiver) {
        super("show", client, receiver);
    }

    @Override
    public void execute() {
        result = receiver.show();
    }

    @Override
    public ArrayDeque<Movie> getResult() {
        return result;
    }
}
