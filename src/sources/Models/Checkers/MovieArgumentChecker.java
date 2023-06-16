package Models.Checkers;

import Enums.Color;
import Enums.Country;
import Enums.MovieGenre;
import Enums.MpaaRating;
import Models.Coordinates;
import Models.Location;
import Models.Person;
import exceptions.WrongArgumentException;

import java.time.LocalDate;

public class MovieArgumentChecker {
    public static void checkMovie(String name, Coordinates coordinates, LocalDate creationDate, Long oscarsCount, MovieGenre genre,
                                  MpaaRating mpaaRating, Person operator) throws WrongArgumentException {
        checkNotNull(name, "name");
        checkCondition(!name.equals(""), "��� ������ �� ������ ���� ������ �������");
        checkNotNull(coordinates, "coordinates");
        checkCoordinates(coordinates.getX(), coordinates.getY());
        checkNotNull(creationDate, "coordinates");
        checkNotNull(oscarsCount, "coordinates");
        checkCondition(oscarsCount >= 0, "���������� ������� ������ ���� >= 0");
        checkNotNull(genre, "genre");
        checkNotNull(mpaaRating, "mpaaRating");
        checkNotNull(operator, "operator");
        checkPerson(operator.getName(), operator.getWeight(), operator.getAge(), operator.getEyeColor(),
                operator.getHairColor(), operator.getNationality(), operator.getLocation());
    }

    private static void checkCoordinates(Double x, Float y) throws WrongArgumentException {
        checkNotNull(x, "������� X");
        checkNotNull(y, "������� Y");
    }

    private static void checkPerson(String name, Integer weight, Integer age, Color eyeColor, Color hairColor,
                                   Country nationality, Location location) throws WrongArgumentException {
        checkNotNull(name, "name");
        checkCondition(!name.equals(""), "��� ��������� �� ������ ���� ������ �������");
        checkNotNull(weight, "weight");
        checkCondition(weight > 0, "��� ��������� ������ ���� > 0");
        checkNotNull(age, "age");
        checkCondition(age > 0, "������� ��������� ������ ���� > 0");
        checkNotNull(eyeColor, "eyeColor");
        checkNotNull(hairColor, "hairColor");
        checkNotNull(nationality, "nationality");
        checkNotNull(location, "location");
        checkLocation(location.getX(), location.getY(), location.getZ());
    }

    private static void checkLocation(Double x, Float y, Integer z) throws WrongArgumentException {
        checkNotNull(x, "������� X");
        checkNotNull(y, "������� Y");
        checkNotNull(z, "������� Z");
    }

    private static void checkCondition(boolean condition, String description) throws WrongArgumentException {
        if (!condition) {
            throw new WrongArgumentException(description);
        }
    }

    private static void checkNotNull(Object object, String name) throws WrongArgumentException {
        if (object == null) {
            throw new WrongArgumentException("���� " + name + " �� ����� ���� null");
        }
    }
 }
