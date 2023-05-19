package Commands;

import Client.Client;
import Server.Receiver;

public class Exit extends AbstractCommand {
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "��������� ���������";
    public Exit(Client client, Receiver receiver) {
        super("exit", client, receiver);
    }

    // TODO: 16.04.2023 ������ ��� ��� ����������, ��� ����� ���� ��� ��� ���? 
    @Override
    public void execute() {
        client.exit();
    }
}