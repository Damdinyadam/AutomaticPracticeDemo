package models;

import java.util.Random;

public enum Gender {
    MALE, FEMALE;

    public static Gender getRandomGender(){
        return values()[new Random().nextInt(values().length)];
    }
}
