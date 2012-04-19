/**
 * 
 */
package universite.toulouse.moodlexmlapi.core.data;

import java.util.List;

/**
 * Class representing the dummy question of type category
 * @author fsil
 *
 */
final public class CategoryQuestion implements Question {
	
	private String category;
	private String course;

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @see universite.toulouse.moodlexmlapi.core.data.Question#getQuestionType()
	 */
	public QuestionType getQuestionType() {
		return QuestionType.category;
	}

	/**
	 * @see universite.toulouse.moodlexmlapi.core.data.Question#getName()
	 */
	public String getName() {
		return null;
	}

	/**
	 * @see universite.toulouse.moodlexmlapi.core.data.Question#getQuestionText()
	 */
	public QuestionText getQuestionText() {
		return null;
	}

	/**
	 * @see universite.toulouse.moodlexmlapi.core.data.Question#getGeneralFeedBack()
	 */
	public String getGeneralFeedBack() {
		return null;
	}

	/**
	 * @see universite.toulouse.moodlexmlapi.core.data.Question#getPenalty()
	 */
	public Float getPenalty() {
		return null;
	}

	/**
	 * @see universite.toulouse.moodlexmlapi.core.data.Question#getDefaultGrade()
	 */
	public Float getDefaultGrade() {
		return null;
	}

	/**
	 * @see universite.toulouse.moodlexmlapi.core.data.Question#isHidden()
	 */
	public Boolean isHidden() {
		return null;
	}

	/**
	 * @see universite.toulouse.moodlexmlapi.core.data.Question#getImageUrl()
	 */
	public String getImageUrl() {
		return null;
	}

	/**
	 * @see universite.toulouse.moodlexmlapi.core.data.Question#getImageBase64()
	 */
	public String getImageBase64() {
		return null;
	}

	/**
	 * @see universite.toulouse.moodlexmlapi.core.data.Question#getErrors()
	 */
	public List<QuestionError> getErrors() {
		return null;
	}

}
