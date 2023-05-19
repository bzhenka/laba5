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
        movieArgs[0] = reader.readLineWithMessage("������� �������� ������: ");
        Double x = null;
        while (x == null) {
            try {
                String xString = reader.readLineWithMessage("������� ���������� x: ");
                x = Double.parseDouble(xString);
            } catch (NumberFormatException e) {
                System.out.println("������� ������� ���������� �");
            }
        }
        movieArgs[1] = String.valueOf(x);
        Float y = null;
        while (y == null){
            String yString = reader.readLineWithMessage("������� ���������� y: ");
            try {
                y = Float.valueOf(yString);
            } catch (NumberFormatException e) {
                System.out.println("������� ������� ���������� y");
            }
        }
        movieArgs[2] = String.valueOf(y);


        Integer oscar = null;
        while (oscar == null){
            String oscarS = reader.readLineWithMessage("������� ���������� �������: ");
            try {
                oscar = Integer.valueOf(oscarS);
                if (oscar < 0){
                    System.out.println("����� �� ������ ���� �������������");
                    oscar = null;
                }
            }catch (NumberFormatException e){
                System.out.println("������� ������� ���������� �������");
            }
        }
        movieArgs[3] = String.valueOf(oscar);
        MovieGenre genre = null;
        while (genre == null){
                String genreS= reader.readLineWithMessage("������� ���� ������: ");
            try {
                genre = MovieGenre.valueOf(genreS);
            }catch (IllegalArgumentException e){
                System.out.println("������� ������ ����");
            }}
        movieArgs[4] = String.valueOf(genre);

        MpaaRating mpaaRating = null;
        while (mpaaRating == null){
            try {
                String mpaaRatingS = reader.readLineWithMessage("������� ���������� �����������: ");
                mpaaRating = MpaaRating.valueOf(mpaaRatingS);
            }catch (IllegalArgumentException e){
                System.out.println("������� ������� ���������� �����������");
            }}
        movieArgs[5] = String.valueOf(mpaaRating);

                    Form operatorForm = new OperatorForm(reader);
        String[] operatorArgs = operatorForm.getData();
        System.arraycopy(operatorArgs, 0, movieArgs, 6, operatorArgs.length);
        return movieArgs;
    }
}
