package ups.m2glre.rossf1.question;

import java.util.ArrayList;
import java.util.List;

import ups.m2glre.rossf1.question.internal.Answer;

/** 
 * ShortAnswerQuestion model.
 */
public class ShortAnswerQuestion extends GenericQuestion {

    private boolean answerShuffle;
    private int useCase;
    private List<Answer> answers = new ArrayList<Answer>();

    public final boolean isAnswerShuffle() {
        return answerShuffle;
    }
    public final void setAnswerShuffle(boolean answerShuffle) {
        this.answerShuffle = answerShuffle;
    }
    public int getUseCase() {
        return useCase;
    }

    public void setUseCase(int useCase) {
        this.useCase = useCase;
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
