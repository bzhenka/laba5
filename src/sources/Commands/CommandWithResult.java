package Commands;

public interface CommandWithResult<T> extends Command {
    T getResult();

}
