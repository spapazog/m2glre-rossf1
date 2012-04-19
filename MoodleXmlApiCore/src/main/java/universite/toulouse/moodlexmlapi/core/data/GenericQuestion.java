/**
 * 
 */
package universite.toulouse.moodlexmlapi.core.data;

import java.util.List;

/**
 * @author fsil
 *
 */
public abstract class GenericQuestion implements Question {
	
	private QuestionType questionType;
	private String name;
	private QuestionText questionText;
	private String generalFeedBack;
	private Float penalty;
	private Float defaultGrade;
	private Boolean isHidden;
	private String imageUrl ;
	private String imageBase64;
	private List<QuestionError> errors;
	
	/**
	 * @return the questionType
	 */
	public QuestionType getQuestionType() {
		return questionType;
	}
	/**
	 * @param questionType the questionType to set
	 */
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the questionText
	 */
	public QuestionText getQuestionText() {
		return questionText;
	}
	/**
	 * @param questionText the questionText to set
	 */
	public void setQuestionText(QuestionText questionText) {
		this.questionText = questionText;
	}
	/**
	 * @return the generalFeedBack
	 */
	public String getGeneralFeedBack() {
		return generalFeedBack;
	}
	/**
	 * @param generalFeedBack the generalFeedBack to set
	 */
	public void setGeneralFeedBack(String generalFeedBack) {
		this.generalFeedBack = generalFeedBack;
	}
	/**
	 * @return the penalty
	 */
	public Float getPenalty() {
		return penalty;
	}
	/**
	 * @param penalty the penalty to set
	 */
	public void setPenalty(Float penalty) {
		this.penalty = penalty;
	}
	/**
	 * @return the defaultGrade
	 */
	public Float getDefaultGrade() {
		return defaultGrade;
	}
	/**
	 * @param defaultGrade the defaultGrade to set
	 */
	public void setDefaultGrade(Float defaultGrade) {
		this.defaultGrade = defaultGrade;
	}
	/**
	 * @return the isHidden
	 */
	public Boolean getIsHidden() {
		return isHidden;
	}
	/**
	 * @param isHidden the isHidden to set
	 */
	public void setIsHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * @return the imageBase64
	 */
	public String getImageBase64() {
		return imageBase64;
	}
	/**
	 * @param imageBase64 the imageBase64 to set
	 */
	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}
	/**
	 * @return the errors
	 */
	public List<QuestionError> getErrors() {
		return errors;
	}
	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<QuestionError> errors) {
		this.errors = errors;
	}

	

}
