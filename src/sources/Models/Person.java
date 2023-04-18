package Models;

import Enums.Color;
import Enums.Country;

public class Person {
    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer weight, Color eyeColor, Color hairColor, Country nationality, Location location) {
        this.name = name;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    private String name;
    private Integer weight;
    private Color eyeColor;
    private Color hairColor;
    private Country nationality;
    private Location location;

}
