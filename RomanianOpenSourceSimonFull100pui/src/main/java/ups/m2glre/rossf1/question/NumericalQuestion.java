package ups.m2glre.rossf1.question;

public class NumericalQuestion extends GenericQuestion {
    private int answerFraction;
    private int answerValue;
    private int answerTolerence;
    private int answerUnitMultiplier;
    private boolean answerShuffle;
    private String answerUnitName;
    private String feedbackText;
    /**
     * @return the answerFraction
     */
    public final int getAnswerFraction() {
        return answerFraction;
    }
    /**
     * @param answerFraction the answerFraction to set
     */
    public final void setAnswerFraction(int answerFraction) {
        this.answerFraction = answerFraction;
    }
    /**
     * @return the answerValue
     */
    public final int getAnswerValue() {
        return answerValue;
    }
    /**
     * @param answerValue the answerValue to set
     */
    public final void setAnswerValue(int answerValue) {
        this.answerValue = answerValue;
    }
    /**
     * @return the answerTolerence
     */
    public final int getAnswerTolerence() {
        return answerTolerence;
    }
    /**
     * @param answerTolerence the answerTolerence to set
     */
    public final void setAnswerTolerence(int answerTolerence) {
        this.answerTolerence = answerTolerence;
    }
    /**
     * @return the answerUnitMultiplier
     */
    public final int getAnswerUnitMultiplier() {
        return answerUnitMultiplier;
    }
    /**
     * @param answerUnitMultiplier the answerUnitMultiplier to set
     */
    public final void setAnswerUnitMultiplier(int answerUnitMultiplier) {
        this.answerUnitMultiplier = answerUnitMultiplier;
    }
    /**
     * @return the answerShuffle
     */
    public final boolean isAnswerShuffle() {
        return answerShuffle;
    }
    /**
     * @param answerShuffle the answerShuffle to set
     */
    public final void setAnswerShuffle(boolean answerShuffle) {
        this.answerShuffle = answerShuffle;
    }
    /**
     * @return the answerUnitName
     */
    public final String getAnswerUnitName() {
        return answerUnitName;
    }
    /**
     * @param answerUnitName the answerUnitName to set
     */
    public final void setAnswerUnitName(String answerUnitName) {
        this.answerUnitName = answerUnitName;
    }
    /**
     * @return the feedbackText
     */
    public final String getFeedbackText() {
        return feedbackText;
    }
    /**
     * @param feedbackText the feedbackText to set
     */
    public final void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }
}
