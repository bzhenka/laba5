import InputOutput.MovieCollectionCSVFileReader;

class Main{
    public static void main(String[] args) {
        MovieCollectionCSVFileReader movieCollectionCSVFileReader = new MovieCollectionCSVFileReader("file.csv");
        movieCollectionCSVFileReader.read();
    }
}