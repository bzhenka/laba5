package InputOutput;

import Server.MovieCollection;
import exceptions.IncorrectFileException;

import java.io.IOException;

public interface MovieCollectionFileReader {
    MovieCollection read() throws IOException, IncorrectFileException;
}
