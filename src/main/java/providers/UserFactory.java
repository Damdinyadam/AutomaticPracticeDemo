package providers;

import models.Gender;
import models.User;


public class UserFactory {


    public User getAlreadyRegisteredUser() {
        return User.builder()
                .email("existing.user@wp.pl")
                .gender(Gender.FEMALE)
                .firstName("Anna")
                .lastName("Ventur")
                .password("a.ventur@")
                .street("street1")
                .city("New York")
                .state("Alaska")
                .postalCode("02756")
                .country("United States")
                .phone("234888")
                .alias("adress2")
                .build();
    }

    public User getRandomUser() {
        RandomStringGenerator rnd = new RandomStringGenerator();
        RandomIntGenerator rndInt = new RandomIntGenerator();

        return User.builder()
                .email(rnd.getRandomEmail(7))
                .gender(Gender.getRandomGender())
                .firstName(rnd.getRandomString(6))
                .lastName(rnd.getRandomString(10))
                .password(rnd.getRandomPassword(8))
//                .dayOfBirth(rndInt.generateRandomIntBound(1, 29))
//                .monthOfBirth(rndInt.generateRandomIntBound(1, 13))
//                .yearOfBirth(rndInt.generateRandomIntBound(1950, 2010))
                .street(rnd.getRandomString(8))
                .city(rnd.getRandomString(5))
                .state("Alabama")
                .postalCode(rnd.getRandomNumbers(5))
                .country("United States")
                .phone(rnd.getRandomNumbers(6))
                .alias(rnd.getRandomString(5))
                .build();
    }
}