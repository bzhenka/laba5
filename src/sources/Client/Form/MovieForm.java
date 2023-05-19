package Client.Form;

import Enums.MovieGenre;
import Enums.MpaaRating;
import InputOutput.Reader;
import exceptions.WrongArgumentException;

public class MovieForm extends Form{
    public MovieForm(Reader reader) {
        super(reader);
    }

    @Override
    public String[] getData() throws WrongArgumentException {
        String[] movieArgs = new String[15];
        movieArgs[0] = reader.readLineWithMessage("Введите название фильма: ");
        Double x = null;
        while (x == null) {
            try {
                String xString = reader.readLineWithMessage("Введите координату x: ");
                x = Double.parseDouble(xString);
            } catch (NumberFormatException e) {
                System.out.println("Неверно введена координата х");
            }
        }
        movieArgs[1] = String.valueOf(x);
        Float y = null;
        while (y == null){
            String yString = reader.readLineWithMessage("Введите координату y: ");
            try {
                y = Float.valueOf(yString);
            } catch (NumberFormatException e) {
                System.out.println("Неверно введена координата y");
            }
        }
        movieArgs[2] = String.valueOf(y);


        Integer oscar = null;
        while (oscar == null){
            String oscarS = reader.readLineWithMessage("Введите количество оскаров: ");
            try {
                oscar = Integer.valueOf(oscarS);
                if (oscar < 0){
                    System.out.println("Число не должно быть отрицательным");
                    oscar = null;
                }
            }catch (NumberFormatException e){
                System.out.println("Неверно введено количество оскаров");
            }
        }
        movieArgs[3] = String.valueOf(oscar);
        MovieGenre genre = null;
        while (genre == null){
                String genreS= reader.readLineWithMessage("Введите жанр фильма: ");
            try {
                genre = MovieGenre.valueOf(genreS);
            }catch (IllegalArgumentException e){
                System.out.println("Неверно введен жанр");
            }}
        movieArgs[4] = String.valueOf(genre);

        MpaaRating mpaaRating = null;
        while (mpaaRating == null){
            try {
                String mpaaRatingS = reader.readLineWithMessage("Введите возрастное ограничение: ");
                mpaaRating = MpaaRating.valueOf(mpaaRatingS);
            }catch (IllegalArgumentException e){
                System.out.println("Неверно введено возрастное ограничение");
            }}
        movieArgs[5] = String.valueOf(mpaaRating);

                    Form operatorForm = new OperatorForm(reader);
        String[] operatorArgs = operatorForm.getData();
        System.arraycopy(operatorArgs, 0, movieArgs, 6, operatorArgs.length);
        return movieArgs;
    }
}
