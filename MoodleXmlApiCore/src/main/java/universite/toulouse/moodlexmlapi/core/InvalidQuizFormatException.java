package universite.toulouse.moodlexmlapi.core;

public class InvalidQuizFormatException extends Exception {

	public InvalidQuizFormatException(Throwable parentException) {
		super("invalidQuizFormat", parentException);
	}


}
