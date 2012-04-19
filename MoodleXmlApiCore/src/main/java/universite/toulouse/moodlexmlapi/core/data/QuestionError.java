package universite.toulouse.moodlexmlapi.core.data;

public class QuestionError {
	
	private String code;
	private String description;

	/**
	 * Create a question error object
	 * @param code
	 * @param description
	 */
	public QuestionError(String code, String description) {
		this.code = code;
		this.description = description;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


}
