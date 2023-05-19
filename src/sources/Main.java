import Client.*;
import Server.Receiver;

import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException {
        Receiver receiver = new Receiver();
        Client client = new ConsoleClient(receiver);
        client.worker();
    }
}