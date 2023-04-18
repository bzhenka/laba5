package Commands;

import Interface.Client;
import Server.Receiver;

public class Clear extends AbstractCommand{

    public Clear(Client client, Receiver receiver) {
        super("clear", client, receiver);
    }

    @Override
    public void fulfill() {

    }
}
