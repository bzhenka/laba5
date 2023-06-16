package Commands;

import Client.Client;
import Server.Receiver;
import exceptions.MovieNotFoundException;

public class UpdateId extends AbstractCommand{
    public static final int ARGS_LENGTH = 1;
    public static final String DESCRIPTION = "обновить значение элемента коллекции, id которого равен заданному";
    int id;
    String[] movieArguments;
    public UpdateId(Client client, Receiver receiver, int id, String[] movieArguments) {
        super("updateId", client, receiver);
        this.id = id;
        this.movieArguments = movieArguments;
    }

    @Override
    public void execute() throws MovieNotFoundException {
        receiver.updateId(id, movieArguments);
    }
}
