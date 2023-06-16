package Client.Form;

import Enums.ConsoleColor;
import Enums.MovieGenre;
import Enums.MpaaRating;
import InputOutput.Reader;
import exceptions.InputInterruptionException;
import exceptions.WrongArgumentException;

import java.util.Objects;

public class MovieForm extends Form{
    public MovieForm(Reader reader) {
        super(reader);
    }

    @Override
    public String[] getData() throws WrongArgumentException, InputInterruptionException {
        String[] movieArgs = new String[15];
        String name = null;
        while (name == null){
            name = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "������� �������� ������: ");

            if (name.equalsIgnoreCase("cancel")) {
                throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");
            }

            if (Objects.equals(name, "")){
                name = null;
                System.out.println(ConsoleColor.RED.getCode() + "��� �� ����� ���� ������");
            }
        }
        movieArgs[0] = name;
        Double x = null;

        while (x == null) {

            try {
                String xString = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() +"������� ���������� x (������) : ");
                if (xString.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");}
//                if (xString.equals("?")){
//                    movieArgs[1] = "?";
//                    break;
//                }
                x = Double.parseDouble(xString);
                if (x < 0 || x > 90){
                    System.out.println(ConsoleColor.RED.getCode() + "���������� � �� ����� �������� �� ����� [0; 90]");
                    x = null;
                }

            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.RED.getCode() + "������� ������� ���������� �");

            }
        }
        movieArgs[1] = String.valueOf(x);
//        if (!Objects.equals(movieArgs[1], "?")){
//            movieArgs[1] = String.valueOf(x);
//        }

        Float y = null;
        while (y == null){
            String yString = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() +"������� ���������� y (�������) : ");
            if (yString.equalsIgnoreCase("cancel")) {
                throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");}

            try {
                y = Float.valueOf(yString);
                if (y < 0 || y > 180){
                    System.out.println(ConsoleColor.RED.getCode() + "���������� y �� ����� �������� �� ����� [0; 180]");
                    y = null;}

            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.RED.getCode() + "������� ������� ���������� y");
            }
        }
        movieArgs[2] = String.valueOf(y);


        Integer oscar = null;
        while (oscar == null){
            String oscarS = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() +"������� ���������� �������: ");
            if (oscarS.equalsIgnoreCase("cancel")) {
                throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");}
            try {
                oscar = Integer.valueOf(oscarS);
                if (oscar < 0){
                    System.out.println(ConsoleColor.RED.getCode() + "����� �� ������ ���� �������������");
                    oscar = null;
                }
            }catch (NumberFormatException e){
                System.out.println(ConsoleColor.RED.getCode() + "������� ������� ���������� �������");
            }
        }
        movieArgs[3] = String.valueOf(oscar);
        MovieGenre genre = null;
        while (genre == null){
                String genreS= reader.readLineWithMessage(ConsoleColor.CYAN.getCode() +"������� ���� ������: ");
            if (genreS.equalsIgnoreCase("cancel")) {
                throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");}
            try {
                genreS = genreS.toUpperCase();
                genre = MovieGenre.valueOf(genreS);
            }catch (IllegalArgumentException e){
                System.out.println(ConsoleColor.RED.getCode() + "������� ������ ����");
            }}
        movieArgs[4] = String.valueOf(genre);

        MpaaRating mpaaRating = null;
        while (mpaaRating == null){
            try {
                String mpaaRatingS = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() +"������� ���������� ����������� (G, PG, PG_13, R, NC_17): ");
                if (mpaaRatingS.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");}
                mpaaRatingS = mpaaRatingS.toUpperCase();
                mpaaRating = MpaaRating.valueOf(mpaaRatingS);
            }catch (IllegalArgumentException e){
                System.out.println(ConsoleColor.RED.getCode() + "������� ������� ���������� �����������");
            }}
        movieArgs[5] = String.valueOf(mpaaRating);

        Form operatorForm = new OperatorForm(reader);
        String[] operatorArgs = operatorForm.getData();
        System.arraycopy(operatorArgs, 0, movieArgs, 6, operatorArgs.length);
        return movieArgs;
    }
}
