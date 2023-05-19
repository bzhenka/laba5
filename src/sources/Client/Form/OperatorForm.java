package Client.Form;

import Enums.Color;
import Enums.Country;
import InputOutput.Reader;
import exceptions.WrongArgumentException;

import java.util.Objects;

public class OperatorForm extends Form{
    public OperatorForm(Reader reader) {
        super(reader);
    }

    @Override
    public String[] getData() throws WrongArgumentException{
        String[] movieArgs = new String[9];
        String name = null;
        while (name==null){
            String nameS = reader.readLineWithMessage("������� ��� ���������: ");
            if (!Objects.equals(nameS, "")) {
                name = nameS;
            } else {
                System.out.println("��� �� ����� ���� ������");
            }
        }
        movieArgs[0] = name;

        Integer weight = null;
        while (weight == null){
            try {
                String weightS =  reader.readLineWithMessage("������� ��� ���������: ");
                weight = Integer.parseInt(weightS);
                if (weight < 0){
                    throw new WrongArgumentException("������� ������ ���");
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());}}
        movieArgs[1] = String.valueOf(weight);

        Integer age = null;
        while (age == null){
            try {
                String ageS = reader.readLineWithMessage("������� ������� ���������: ");
                age = Integer.parseInt(ageS);
                if (age < 0){
                    throw new WrongArgumentException("������� ������ �������");
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());}}
        movieArgs[2] = String.valueOf(age);


        Color color = null;
        while (color == null){
            try {
                String colorS = reader.readLineWithMessage("������� ���� ���� ���������: ");
                color = Color.valueOf(colorS);
            }catch (IllegalArgumentException e){
                System.out.println("������� ������ ���� ����");
            }}
        movieArgs[3] = String.valueOf(color);



        Color color1 = null;
        while (color1 == null){
            try {
                String colorS = reader.readLineWithMessage("������� ���� ����� ���������: ");
                color1 = Color.valueOf(colorS);
            }catch (IllegalArgumentException e){
                System.out.println("������� ������ ���� �����");
            }}
        movieArgs[4] = String.valueOf(color1);

        Country country = null;
        while(country == null){

            try {
                String countyS = reader.readLineWithMessage("������� �������������� ���������: ");
                country = Country.valueOf(countyS);
            }catch (IllegalArgumentException e){
                System.out.println("������� ������� ������ ���������");
            }}
        movieArgs[5] = String.valueOf(country);
        Double x = null;
        while (x == null) {
            try {
                String xString = reader.readLineWithMessage("������� ���������� x: ");
                x = Double.parseDouble(xString);
            } catch (NumberFormatException e) {
                System.out.println("������� ������� ���������� �");
            }
        }
        movieArgs[6] = String.valueOf(x);
        Float y = null;
        while (y == null){
            String yString = reader.readLineWithMessage("������� ���������� y: ");
            try {
                y = Float.valueOf(yString);
            } catch (NumberFormatException e) {
                System.out.println("������� ������� ���������� y");
            }
        }
        movieArgs[7] = String.valueOf(y);
        Integer z = null;
        while(z == null){
            try {
                String zString = reader.readLineWithMessage("������� ���������� z: ");
                z = Integer.valueOf(zString);
            } catch (NumberFormatException e) {
                System.out.println("������� ������� ���������� z ");
            }}
        movieArgs[8] = String.valueOf(z);
        return movieArgs;

}}
