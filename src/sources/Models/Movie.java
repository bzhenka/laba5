package Models;

import Enums.MovieGenre;
import Enums.MpaaRating;

import java.time.LocalDate;

public class Movie {
    private static Integer nextID = 1;
    private int id;
    private String name;
    private Coordinates coordinates;
    private java.time.LocalDate creationDate;
    private Long oscarsCount;
    private MovieGenre genre;
    private MpaaRating mpaaRating;
    private Person operator;

    public Movie(String name, Coordinates coordinates, Long oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person operator){
        this.id = nextID;
        nextID += 1;
        this.name = name;
        this.coordinates = coordinates;
        this.oscarsCount = oscarsCount;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.operator = operator;
    }
    public Movie(String name, Coordinates coordinates, java.time.LocalDate creationDate, Long oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person operator){
        this.id = nextID;
        nextID += 1;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.oscarsCount = oscarsCount;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.operator = operator;
    }

    // TODO: 16.04.2023 сделать автоматически обновляемый id так чтобы придабавлии фильма последним он просто добавлял id, при добавлении первым передвигал все id, итакже при удалении
//    public static void updateNextID(int startIndex) {
//        int id = startIndex + 1;
//        for (int i = startIndex; i < movies.size(); i++) {
//            movies.get(i).setId(id++);
//        }
//    }
    public int getId() {
        return id;
    }
    //этот метод добавляет новый id к существующему
    public void setId(){
        this.id = nextID;
        nextID += 1;
    }

    public String getName() {
        return name;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }



    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Long getOscarsCount() {
        return oscarsCount;
    }


    public MovieGenre getGenre() {
        return genre;
    }

    public MpaaRating getMpaaRating() {
        return mpaaRating;
    }

    public Person getOperator() {
        return operator;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setOscarsCount(Long oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public void setMpaaRating(MpaaRating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public void setOperator(Person operator) {
        this.operator = operator;
    }

    @Override
    public String toString(){
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", oscarsCount=" + oscarsCount +
                ", genre=" + genre +
                ", mpaaRating=" + mpaaRating +
                ", operator=" + operator +
                "}";
    }


}
