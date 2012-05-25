package ups.m2glre.rossf1.question;

import java.util.HashMap;

/** Matching question model
 */

public class MatchingQuestion extends GenericQuestion {

    HashMap<String, String> subquestions = new HashMap<String, String>();
    boolean suffleAnswer;

    public void addSubquestion(String text, String answer) {
        subquestions.put(text, answer);
    }

    public boolean isSuffleAnswer() {
        return suffleAnswer;
    }

    public void setSuffleAnswer(boolean suffleAnswer) {
        this.suffleAnswer = suffleAnswer;
    }

    public HashMap<String, String> getSubquestion() {
        return subquestions;
    }
}
