package providers;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator {

    public String getRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String getRandomPassword(int length){
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public String getRandomNumbers(int length){
       return  RandomStringUtils.randomNumeric(length);
    }
    public String getRandomEmail(int length){
        return getRandomString(length) + "@gmail.com";
    }

}
