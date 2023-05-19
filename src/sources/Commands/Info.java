package Commands;

import Client.Client;
import Server.Receiver;

public class Info extends AbstractCommandResult<String[]>{
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "вывести в стандартный поток вывода информацию о коллекции";
    public Info(Client client, Receiver receiver) {
        super("info", client, receiver);
    }

    @Override
    public void execute() {
        result = (receiver.info());
    }

    @Override
    public String[] getResult() {
        return result;
    }
}
