package InputOutput;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private final Scanner readConsole = new Scanner(System.in);
    @Override
    public String readLine() {
        String InputAString = readConsole.nextLine();
        return InputAString;
    }

    @Override
    public String readLineWithMessage(String message) {
        System.out.print(message);
        return readLine();
    }

    @Override
    public boolean hasNextLine() {
        return readConsole.hasNextLine();
    }
}
