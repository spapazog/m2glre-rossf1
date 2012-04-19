package universite.toulouse.moodlexmlapi.core.data;

/**
 * @author fsil
 *
 */
public class QuestionText {
	
	private String text;
	private QuestionTextFormat questionTextFormat;
	
	/**
	 * Construct a question text
	 * @param text the text
	 * @param questionTextFormat the text format
	 */
	public QuestionText(String text, QuestionTextFormat questionTextFormat) {
		this.text = text;
		this.questionTextFormat = questionTextFormat;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @return the questionTextFormat
	 */
	public QuestionTextFormat getQuestionTextFormat() {
		return questionTextFormat;
	}
	

}
