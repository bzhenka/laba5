package Commands;

import Client.Client;
import Models.Movie;
import Server.Receiver;

import java.util.ArrayDeque;

public class FilterLessThanOscarsCount extends AbstractCommandResult<ArrayDeque<Movie>> {
    public static final int ARGS_LENGTH = 1;
    public static final String DESCRIPTION = "вывести элементы, значение поля oscarsCount которых меньше заданного";
    private final Long oscarCount;
    public FilterLessThanOscarsCount(Client client, Receiver receiver, Long oscarCount) {
        super("filterLessThanOscarsCount", client, receiver);
        this.oscarCount=oscarCount;
    }

    @Override
    public void execute() {
        result = receiver.filterLessThanOscarsCount(oscarCount);
    }

    @Override
    public ArrayDeque<Movie> getResult() {
        return result;
    }
}
