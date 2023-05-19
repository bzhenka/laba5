package Commands;

import Client.Client;
import Server.Receiver;

import java.io.IOException;

public class Save extends AbstractCommand{
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "��������� ��������� � ����";
    public Save(Client client, Receiver receiver) {
        super("save", client, receiver);
    }

    @Override
    public void execute() throws IOException {
        receiver.save();
    }
}
