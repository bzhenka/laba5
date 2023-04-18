package Interface;

public interface CommandWithResult<T> extends Command {
    T getResult();

}
