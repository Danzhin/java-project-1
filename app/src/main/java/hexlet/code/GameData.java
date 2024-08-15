package hexlet.code;

public class GameData {
    public final int countRound = 3;
    public final String userName;
    public final String rules;
    public String[] questions;
    public String[] correctAnswers;

    public GameData(String userName, String rules) {
        this.userName = userName;
        this.rules = rules;
        questions = new String[countRound];
        correctAnswers = new String[countRound];
    }
}
