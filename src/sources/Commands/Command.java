package Commands;

import exceptions.MovieNotFoundException;

import java.io.IOException;

public interface Command {
    void execute() throws IOException, MovieNotFoundException;
}
