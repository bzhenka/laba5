package Commands;

import Interface.Client;
import Server.Receiver;

public class Exit extends AbstractCommand {
    protected Exit(Client client, Receiver receiver) {
        super("exit", client, receiver);
    }

    // TODO: 16.04.2023 ������ ��� ��� ����������, ��� ����� ���� ��� ��� ���? 
    @Override
    public void fulfill() {
        client.exit();
    }
}