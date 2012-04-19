package universite.toulouse.moodlexmlapi.core.data;

import java.util.List;
/**
 * Interface representing a Moodle quiz
 * @author fsil 
 *
 */
public interface Quiz {
	
	/**
	 * @return the question list
	 */
	public List<Question> getQuestionList();

}
