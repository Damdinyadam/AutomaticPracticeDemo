package providers;

import java.util.Random;

public class RandomIntGenerator {
    Random rnd = new Random();

    public int generateRandomIntBound(int min, int max) {
        return rnd.nextInt(max - min) + min;
    }

    public int generateRandomIndex(int bound) {
        return rnd.nextInt(bound);
    }

    public int generatePostalCode() {
        return 10000 + rnd.nextInt(90000);
    }

    public int generateMobilePhoneNumber() {
        return 100000000 + rnd.nextInt(900000000);
    }


}
