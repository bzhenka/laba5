package Server;

import InputOutput.MovieCollectionFileReader;
import InputOutput.MovieCollectionFileWriter;

public class Receiver {
    private final MovieCollection movieCollection;
    MovieCollectionFileReader csvFileReader;
    MovieCollectionFileWriter csvFileWriter;
    public Receiver(MovieCollection movieCollection){
        this.movieCollection = movieCollection;
        // TODO: 16.04.2023 ������� ���������� ���������
        String file = System.getenv("LAB5");
//        this.csvFileReader =

    }



}
