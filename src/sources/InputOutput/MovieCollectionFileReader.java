package InputOutput;

import Server.MovieCollection;

import java.io.IOException;

public interface MovieCollectionFileReader {
    MovieCollection read() throws IOException;
}
