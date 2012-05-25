package ups.m2glre.rossf1.question;

public class MultichoiceQuestion extends GenericQuestion{
	private int answerFraction;
	private String answerText;
	private String feedbackText;
	private boolean answerShuffle;
	private boolean single;
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
