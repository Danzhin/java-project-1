package hexlet.code;

public class Utils {

    public static int createRandomNumber(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
    }

}
