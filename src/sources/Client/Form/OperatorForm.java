package Client.Form;

import Enums.Color;
import Enums.ConsoleColor;
import Enums.Country;
import InputOutput.Reader;
import exceptions.InputInterruptionException;
import exceptions.WrongArgumentException;

import java.util.Objects;

public class OperatorForm extends Form{
    public OperatorForm(Reader reader) {
        super(reader);
    }

    @Override
    public String[] getData() throws WrongArgumentException, InputInterruptionException {
        String[] movieArgs = new String[9];
        String name = null;
        while (name == null){
            name = reader.readLineWithMessage("������� ��� ���������: ");

            if (name.equalsIgnoreCase("cancel")) {
                throw new InputInterruptionException("\n �� ����� �� �������");
            }

            if (Objects.equals(name, "")){
                name = null;
                System.out.println(ConsoleColor.RED.getCode() + "��� �� ����� ���� ������");
            }
        }
        movieArgs[0] = name;

        Integer weight = null;
        while (weight == null){
            try {
                String weightS =  reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "������� ��� ���������: ");
                if (weightS.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");
                }
                weight = Integer.parseInt(weightS);
                if (weight <= 0){
                    System.out.println(ConsoleColor.RED.getCode() + "��� �� ����� ���� �������������");
                    weight = null;
                }

            }catch (NumberFormatException e){
                System.out.println(ConsoleColor.RED.getCode() + "������� ����� ���");}}
        movieArgs[1] = String.valueOf(weight);

        Integer age = null;
        while (age == null){
            try {
                String ageS = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "������� ������� ���������: ");
                if (ageS.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");
                }
                age = Integer.parseInt(ageS);
                if (age <= 0){
                    System.out.println(ConsoleColor.RED.getCode() + "������� �� ����� ���� �������������");
                    age = null;
                }
            }catch (NumberFormatException e){
                System.out.println(ConsoleColor.RED.getCode() + "������� ����� ���");}}
        movieArgs[2] = String.valueOf(age);


        Color color = null;
        while (color == null){
            try {
                String colorS = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "������� ���� ���� ���������: ");
                if (colorS.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");
                }
                colorS = colorS.toUpperCase();
                color = Color.valueOf(colorS);
            }catch (IllegalArgumentException e){
                System.out.println(ConsoleColor.RED.getCode() + "������� ������ ���� ����");
            }}
        movieArgs[3] = String.valueOf(color);



        Color color1 = null;
        while (color1 == null){
            try {
                String colorS = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "������� ���� ����� ���������: ");
                if (colorS.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");
                }
                colorS = colorS.toUpperCase();
                color1 = Color.valueOf(colorS);
            }catch (IllegalArgumentException e){
                System.out.println(ConsoleColor.RED.getCode() + "������� ������ ���� �����");
            }}
        movieArgs[4] = String.valueOf(color1);

        Country country = null;
        while(country == null){

            try {
                String countryS = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "������� �������������� ���������: ");
                if (countryS.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");
                }
                countryS = countryS.toUpperCase();
                country = Country.valueOf(countryS);
            }catch (IllegalArgumentException e){
                System.out.println(ConsoleColor.RED.getCode() + "������� ������� ������ ���������");
            }}
        movieArgs[5] = String.valueOf(country);
        Double x = null;
        while (x == null) {
            try {
                String xString = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "������� ���������� x: ");
                if (xString.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");
                }
                x = Double.parseDouble(xString);
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.RED.getCode() + "������� ������� ���������� �");
            }
        }
        movieArgs[6] = String.valueOf(x);
        Float y = null;
        while (y == null){
            String yString = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "������� ���������� y: ");
            if (yString.equalsIgnoreCase("cancel")) {
                throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");
            }
            try {
                y = Float.valueOf(yString);
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.RED.getCode() + "������� ������� ���������� y");
            }
        }
        movieArgs[7] = String.valueOf(y);
        Integer z = null;
        while(z == null){
            try {
                String zString = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "������� ���������� z: ");
                if (zString.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n �� ����� �� �������");
                }
                z = Integer.valueOf(zString);
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.RED.getCode() + "������� ������� ���������� z ");
            }}
        movieArgs[8] = String.valueOf(z);
        return movieArgs;

}}
