package ups.m2glre.rossf1.question;

import java.util.ArrayList;
import java.util.List;

import ups.m2glre.rossf1.question.internal.Answer;

/** TrueFalseQuestion model
 */
public class TrueFalseQuestion extends GenericQuestion {

    private boolean answerShuffle;
    private List<Answer> answers = new ArrayList<Answer>(2);

    public final boolean isAnswerShuffle() {
        return answerShuffle;
    }
    public final void setAnswerShuffle(boolean answerShuffle) {
        this.answerShuffle = answerShuffle;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
    public void addAnswer(Answer answer) {
        answers.add(answer);
    }
    public void setAnswer(List<Answer> answers) {
        this.answers = answers;
    }
}
