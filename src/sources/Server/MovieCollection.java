package Server;

import Models.Movie;

import java.util.*;

public class MovieCollection {
    private ArrayDeque<Movie> movieArrayDeque = new ArrayDeque<>();
    public void addMovie(Movie movie) {
        movieArrayDeque.addLast(movie);
    }
    public void removeFirstMovie() {
        movieArrayDeque.removeFirst();
    }
    public void removeLastMovie(){
        movieArrayDeque.removeLast();
    }
    // получение количества фильмов в коллекции
    public int getSize() {
        return movieArrayDeque.size();
    }



}
