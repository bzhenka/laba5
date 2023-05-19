package InputOutput;

import Server.MovieCollection;

import java.io.IOException;

public interface MovieCollectionFileWriter {
    void write(MovieCollection movieCollection) throws IOException;
}
