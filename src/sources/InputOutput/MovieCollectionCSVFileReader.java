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

import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import com.opencsv.*;

public class MovieCollectionCSVFileReader implements MovieCollectionFileReader {
    private final String filepath;
    private final char delimiter = ';';
    private final MovieCollection movieCollection = new MovieCollection();

    public MovieCollectionCSVFileReader(String filename) {
        this.filepath = filename;
    }

    @Override
    public MovieCollection read() throws IOException {
        try {
            FileReader fileReader = new FileReader(filepath);
            CSVReader csvReader = new CSVReader(fileReader, delimiter);
            String[] nextRecord;
            if ((nextRecord = csvReader.readNext()) == null) {
                fileReader.close();
                return new MovieCollection();
            }

            ZonedDateTime initializationDate = ZonedDateTime.parse(csvReader.readNext()[0]);
            movieCollection.setInitializationDate(initializationDate);

            csvReader.readNext();


            while ((nextRecord = csvReader.readNext()) != null) {
                String name = nextRecord[0];
                double coordinates_x = Double.parseDouble(nextRecord[1]);

                Float coordinates_y = Float.parseFloat(nextRecord[2]);
                Coordinates coordinates = new Coordinates(coordinates_x, coordinates_y);

                java.time.LocalDate creationDate = java.time.LocalDate.parse(nextRecord[3]);

                Long oscarCount = Long.parseLong(nextRecord[4]);

                MovieGenre movieGenre = MovieGenre.valueOf(nextRecord[5]);
                MpaaRating mpaaRating = MpaaRating.valueOf(nextRecord[6]);

                String operatorName = nextRecord[7];
                Integer weight = Integer.valueOf(nextRecord[8]);
                Integer age = Integer.valueOf(nextRecord[9]);
                Color eyeColor = Color.valueOf(nextRecord[10]);
                Color hairColor = Color.valueOf(nextRecord[11]);
                Country nationality = Country.valueOf(nextRecord[12]);
                double location_x = Double.parseDouble(nextRecord[13]);
                Float location_y = Float.valueOf(nextRecord[14]);
                Integer location_z = Integer.valueOf(nextRecord[15]);
                Location location = new Location(location_x, location_y, location_z);
                Person operator = new Person(operatorName, weight, age, eyeColor, hairColor, nationality, location);
                Movie movie = new Movie(name, coordinates, oscarCount, movieGenre, mpaaRating, operator);
                movie.setCreationDate(creationDate);

                movieCollection.add(movie);
            }

            fileReader.close();
            return movieCollection;
        } catch (DateTimeParseException e) {
            System.out.println("Файл пуст");
        }
        return null;
    }
}



