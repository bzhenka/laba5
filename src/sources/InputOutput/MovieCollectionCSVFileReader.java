package InputOutput;

import Enums.Color;
import Enums.Country;
import Enums.MovieGenre;
import Enums.MpaaRating;
import Models.Coordinates;
import Models.Location;
import Models.Movie;
import Models.Person;
import Server.MovieCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import com.opencsv.*;
import exceptions.FilePermissionException;
import exceptions.IncorrectFileException;
import exceptions.WrongArgumentException;

import static Models.Checkers.MovieArgumentChecker.checkMovie;

public class MovieCollectionCSVFileReader implements MovieCollectionFileReader {
    private final String filepath;
    private final char delimiter = ';';
    private final File file;

    public MovieCollectionCSVFileReader(String filename) throws FileNotFoundException, FilePermissionException {
        this.filepath = filename;

        file = new File(filename);
        if (!file.exists())
            throw new FileNotFoundException("���� " + filename + " �� ������");
        if (!file.canRead() || !file.canWrite())
            throw new FilePermissionException("������������ ���� ��� ������ �/��� ������ ����� " + filename + "  !");
    }

    @Override
    public MovieCollection read() throws IOException, IncorrectFileException {
        MovieCollection movieCollection = new MovieCollection();
        try (
                FileReader fileReader = new FileReader(filepath);
                CSVReader csvReader = new CSVReader(fileReader, delimiter)
        ) {
            if (file.length() == 0) {
                movieCollection.setInitializationDate(ZonedDateTime.now());
                return movieCollection;
            }

            String[] nextRecord;

            ZonedDateTime initializationDate;
            nextRecord = csvReader.readNext();
            try {
                initializationDate = ZonedDateTime.parse(nextRecord[0]);
            } catch (DateTimeParseException e) {
                throw new IncorrectFileException("�� ������� ��������� ����/�����");
            }
            movieCollection.setInitializationDate(initializationDate);

            // skipping header
            csvReader.readNext();


            while ((nextRecord = csvReader.readNext()) != null) {
                try {
                    String name = nextRecord[0].trim();

                    Double coordinates_x;
                    try {
                        coordinates_x = Double.parseDouble(nextRecord[1]);
                    } catch (NumberFormatException e) {
                        throw new IncorrectFileException("����������� ������� ���������� X");
                    }

                    Float coordinates_y;
                    try {
                        coordinates_y = Float.parseFloat(nextRecord[2]);
                    } catch (NumberFormatException e) {
                        throw new IncorrectFileException("����������� ������� ���������� Y");
                    }

                    Coordinates coordinates = new Coordinates(coordinates_x, coordinates_y);

                    LocalDate creationDate;
                    try {
                        creationDate = LocalDate.parse(nextRecord[3]);
                    } catch (DateTimeParseException e) {
                        throw new IncorrectFileException("����������� ������� ���� �������� ������");
                    }

                    Long oscarCount;
                    try {
                        oscarCount = Long.parseLong(nextRecord[4]);
                    } catch (NumberFormatException e) {
                        throw new IncorrectFileException("����������� ������� ���������� �������");
                    }

                    MovieGenre movieGenre;
                    try {
                        movieGenre = MovieGenre.valueOf(nextRecord[5]);
                    } catch (IllegalArgumentException e) {
                        throw new IncorrectFileException("����������� ������ ���� ������");
                    }

                    MpaaRating mpaaRating;
                    try {
                        mpaaRating = MpaaRating.valueOf(nextRecord[6]);
                    } catch (IllegalArgumentException e) {
                        throw new IncorrectFileException("����������� ������ ������� ������");
                    }

                    String operatorName = nextRecord[7];

                    Integer weight;
                    try {
                        weight = Integer.valueOf(nextRecord[8]);
                    } catch (NumberFormatException e) {
                        throw new IncorrectFileException("����������� ������ ��� ���������");
                    }

                    Integer age;
                    try {
                        age = Integer.valueOf(nextRecord[9]);
                    } catch (NumberFormatException e) {
                        throw new IncorrectFileException("����������� ������ ������� ���������");
                    }

                    Color eyeColor;
                    try {
                        eyeColor = Color.valueOf(nextRecord[10]);
                    } catch (IllegalArgumentException e) {
                        throw new IncorrectFileException("����������� ������ ���� ���� ���������");
                    }

                    Color hairColor;
                    try {
                        hairColor = Color.valueOf(nextRecord[11]);
                    } catch (IllegalArgumentException e) {
                        throw new IncorrectFileException("����������� ������ ���� ����� ���������");
                    }

                    Country nationality;
                    try {
                        nationality = Country.valueOf(nextRecord[12]);
                    } catch (IllegalArgumentException e) {
                        throw new IncorrectFileException("����������� ������� �������������� ���������");
                    }

                    Double location_x;
                    try {
                        location_x = Double.parseDouble(nextRecord[13]);
                    } catch (NumberFormatException e) {
                        throw new IncorrectFileException("����������� ������� ������� X");
                    }

                    Float location_y;
                    try {
                        location_y = Float.parseFloat(nextRecord[14]);
                    } catch (NumberFormatException e) {
                        throw new IncorrectFileException("����������� ������� ������� Y");
                    }

                    Integer location_z;
                    try {
                        location_z = Integer.parseInt(nextRecord[15]);
                    } catch (NumberFormatException e) {
                        throw new IncorrectFileException("����������� ������� ������� Z");
                    }

                    Location location = new Location(location_x, location_y, location_z);
                    Person operator = new Person(operatorName, weight, age, eyeColor, hairColor, nationality, location);

                    // throw exception if args are wrong
                    try {
                        checkMovie(name, coordinates, creationDate, oscarCount, movieGenre, mpaaRating, operator);
                    } catch (WrongArgumentException e) {
                        throw new IncorrectFileException(e.getMessage());
                    }

                    Movie movie = new Movie(name, coordinates, oscarCount, movieGenre, mpaaRating, operator);
                    movie.setCreationDate(creationDate);

                    movieCollection.add(movie);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new IncorrectFileException("�������� ������ � ������");
                }
            }

            return movieCollection;
        }
    }
}



