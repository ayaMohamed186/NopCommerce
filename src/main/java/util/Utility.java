package util;

import java.util.Random;

public class Utility {
    public static int generateRandomInt(int max){
        Random random = new Random();
        return random.nextInt(max) + 1;
    }

}
