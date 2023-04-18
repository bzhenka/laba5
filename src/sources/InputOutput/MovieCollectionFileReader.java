package InputOutput;

import Server.MovieCollection;

import java.io.FileNotFoundException;

public interface MovieCollectionFileReader {
    MovieCollection read() throws FileNotFoundException;
}
