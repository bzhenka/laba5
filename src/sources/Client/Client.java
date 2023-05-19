package Client;

public interface Client {
    void worker();
    void exit();
    void help();

    void executeScript(String filepath);
}
