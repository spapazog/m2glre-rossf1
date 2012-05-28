package ups.m2glre.rossf1.question;

import java.util.HashMap;

/**
 * Matching question model.
 */

public class MatchingQuestion extends GenericQuestion {

    private HashMap<String, String> subquestions = new HashMap<String, String>();
    private boolean shuffleAnswer;

    public void addSubquestion(String text, String answer) {
        subquestions.put(text, answer);
    }

    public boolean isSuffleAnswer() {
        return shuffleAnswer;
    }

    public void setSuffleAnswer(boolean suffleAnswer) {
        this.shuffleAnswer = suffleAnswer;
    }

    public HashMap<String, String> getSubquestion() {
        return subquestions;
    }
}
