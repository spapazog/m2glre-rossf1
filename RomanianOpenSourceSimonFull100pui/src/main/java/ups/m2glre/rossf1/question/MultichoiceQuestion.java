package ups.m2glre.rossf1.question;


/**
*
* @author Simon Joussellin
*
**/
public class MultichoiceQuestion extends GenericQuestion{
    private int answerFraction;
    private String answerText;
    private String feedbackText;
    private boolean answerShuffle;
    private boolean single;
    private String correctfeedbackText;
    private String partiallyfeedbackText;
    private String incorrectfeedbackText;
    private String generalfeedbackText;
    private String answernumbering;

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
    public int getAnswerFraction() {
        return answerFraction;
    }
    public void setAnswerFraction(int answerFraction) {
        this.answerFraction = answerFraction;
    }
    public String getAnswerText() {
        return answerText;
    }
    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
    public String getFeedbackText() {
        return feedbackText;
    }
    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }
    public boolean isAnswerShuffle() {
        return answerShuffle;
    }
    public void setAnswerShuffle(boolean answerShuffle) {
        this.answerShuffle = answerShuffle;
    }

}
