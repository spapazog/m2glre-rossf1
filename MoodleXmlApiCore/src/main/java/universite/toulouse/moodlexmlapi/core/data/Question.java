package universite.toulouse.moodlexmlapi.core.data;

import java.util.List;

/**
 * Interface representing a Moodle question
 * @author fsil
 *
 */
public interface Question {
	
	/**
	 * @return the question type 
	 */
	public QuestionType getQuestionType();
	
	/**
	 * @return the question name
	 */
	public String getName();
	
	/**
	 * @return the question text
	 */
	public QuestionText getQuestionText();
	
	/**
	 * @return the general feedback
	 */
	public String getGeneralFeedBack();
	
	/**
	 * @return the penalty
	 */
	public Float getPenalty();
	
	/**
	 * @return the default grade
	 */
	public Float getDefaultGrade();
	
	/**
	 * @return true if the question was hidden in the quiz
	 */
	public Boolean isHidden();
	
	/**
	 * @return the url image if exists
	 */
	public String getImageUrl();
	
	/**
	 * @return the base 64 encoded string of the image
	 */
	public String getImageBase64();
	
	/**
	 * @return the list of errors associated with the current question
	 */
	public List<QuestionError> getErrors();

}
