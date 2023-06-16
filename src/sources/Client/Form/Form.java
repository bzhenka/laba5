package Client.Form;

import InputOutput.Reader;
import exceptions.InputInterruptionException;
import exceptions.WrongArgumentException;

public abstract class Form {
    protected final Reader reader;

    public Form(Reader reader) {
        this.reader = reader;
    }

    abstract String[] getData() throws WrongArgumentException, InputInterruptionException;
}
