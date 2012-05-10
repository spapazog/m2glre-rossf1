package universite.toulouse.moodlexmlapi.core;

public class InvalidQuizFormatException extends Exception {

	/**
     * Serial.
     */
    private static final long serialVersionUID = 1L;

    public InvalidQuizFormatException(Throwable parentException) {
		super("invalidQuizFormat", parentException);
	}


}
