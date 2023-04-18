package InputOutput;

import Enums.MovieGenre;
import Enums.MpaaRating;
import Models.Coordinates;
import Models.Movie;
import Models.Person;
import Server.MovieCollection;

import java.io.FileReader;
import java.io.IOException;
import com.opencsv.*;

public class MovieCollectionCSVFileReader implements MovieCollectionFileReader {
    private final String filepath;
    private final char delimiter = ';';

    public MovieCollectionCSVFileReader (String filename){
        this.filepath = filename;
    }
    MovieCollection movieCollection = new MovieCollection();
    @Override
    public MovieCollection read() {
        // TODO: 18.04.2023 прочитать try/catch как можно вовнутрь записывать 
        // TODO: 18.04.2023 прочитать про FileReader and CSVReader 
        try (FileReader fileReader = new FileReader(filepath)) {
            CSVReader csvReader = new CSVReader(fileReader, delimiter);
            String[] nextRecord;

            csvReader.readNext();


            while ((nextRecord = csvReader.readNext()) != null) {
                String name = nextRecord[0];
                double x = Double.parseDouble(nextRecord[1]);
                // TODO: 17.04.2023 прочитать о разнице float and Float 
                Float y = Float.parseFloat(nextRecord[2]);
                Coordinates coordinates = new Coordinates(x, y);
                // TODO: 17.04.2023 почитать о parse  
                java.time.LocalDate creationDate = java.time.LocalDate.parse(nextRecord[3]);
                // TODO: 18.04.2023 При использовании метода Long.parseLong() необходимо убедиться, что строка nextRecord[4] действительно содержит число, иначе возникнет исключение NumberFormatException. 
                Long oscarCount = Long.parseLong(nextRecord[4]);
                // TODO: 18.04.2023 прочитать про valueOf
                MovieGenre movieGenre = MovieGenre.valueOf(nextRecord[5]);
                MpaaRating mpaaRating = MpaaRating.valueOf(nextRecord[6]);
                String person = nextRecord[7];
                Person operator = new Person(person);
                Movie movie = new Movie(name, coordinates, creationDate, oscarCount, movieGenre, mpaaRating, operator);

            }
            return movieCollection;
        } catch (IOException e) {
            //todo обработать несуществующий файл
            throw new RuntimeException(e);
        }
    }
}
