package Commands;

import Client.Client;
import Models.Movie;
import Server.Receiver;

import java.util.ArrayList;

public class FilterContainsName extends AbstractCommandResult<ArrayList<Movie>> {
    public static final int ARGS_LENGTH = 1;
    public static final String DESCRIPTION = "вывести элементы, значение поля name которых содержит заданную подстроку";
    private final String name;
    public FilterContainsName(Client client, Receiver receiver, String name) {
        super("filterContainsName", client, receiver);
        this.name = name;
    }

    @Override
    public void execute() {
        result = receiver.filterContainsName(name);
    }

    @Override
    public ArrayList<Movie> getResult() {
        return result;
    }
}
