package ups.m2glre.rossf1.question;

import java.util.ArrayList;
import java.util.List;

import ups.m2glre.rossf1.question.internal.Answer;

/**
* Multichoice Question model.
* @author Simon Joussellin
*
**/
public class MultichoiceQuestion extends GenericQuestion{
    private boolean answerShuffle;
    private boolean single;
    private String correctfeedbackText;
    private String partiallyfeedbackText;
    private String incorrectfeedbackText;
    private String generalfeedbackText;
    private String answernumbering;
    private List<Answer> answers = new ArrayList<Answer>();

    public String getCorrectfeedbackText() {
        return correctfeedbackText;
    }
    public void setCorrectfeedbackText(String correctfeedbackText) {
        this.correctfeedbackText = correctfeedbackText;
    }
    public String getPartiallyfeedbackText() {
        return partiallyfeedbackText;
    }
    public void setPartiallyfeedbackText(String partiallyfeedbackText) {
        this.partiallyfeedbackText = partiallyfeedbackText;
    }
    public String getIncorrectfeedbackText() {
        return incorrectfeedbackText;
    }
    public void setIncorrectfeedbackText(String incorrectfeedbackText) {
        this.incorrectfeedbackText = incorrectfeedbackText;
    }
    public String getGeneralfeedbackText() {
        return generalfeedbackText;
    }
    public void setGeneralfeedbackText(String generalfeedbackText) {
        this.generalfeedbackText = generalfeedbackText;
    }
    public String getAnswernumbering() {
        return answernumbering;
    }
    public void setAnswernumbering(String answernumbering) {
        this.answernumbering = answernumbering;
    }
    public boolean isSingle() {
        return single;
    }
    public void setSingle(boolean single) {
        this.single = single;
    }
    public boolean isAnswerShuffle() {
        return answerShuffle;
    }
    public void setAnswerShuffle(boolean answerShuffle) {
        this.answerShuffle = answerShuffle;
    }
    public List<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
