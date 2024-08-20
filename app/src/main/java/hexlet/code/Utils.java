package hexlet.code;

public class Utils {

    public static int createRandomNumber(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
    }

    public static int[] createProgression(int size, int first, int difference) {
        int[] progression = new int[size];
        for (int i = 0; i < size; i++) {
            progression[i] = first + i * difference;
        }
        return progression;
    }

}
