package Commands;

import Client.Client;
import Server.Receiver;

public class CountLessThanOperator extends AbstractCommandResult<Integer>{
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "вывести количество элементов, значение поля operator которых меньше заданного";
    private final String[] operatorArgs;
    public CountLessThanOperator(Client client, Receiver receiver, String[] operatorArgs) {
        super("countLessThanOperator", client, receiver);
        this.operatorArgs = operatorArgs;
    }

    @Override
    public void execute() {
        result = receiver.countLessThanOperator(operatorArgs);
    }

    @Override
    public Integer getResult() {
        return result;
    }
}
