import Client.*;
import Server.Receiver;
import exceptions.FilePermissionException;
import exceptions.IncorrectFileException;

import java.io.IOException;

class Main{
    public static void main(String[] args) {
        try {
            Receiver receiver = new Receiver();
            Client client = new ConsoleClient(receiver);
            client.worker();
        } catch (IOException | FilePermissionException | IncorrectFileException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}