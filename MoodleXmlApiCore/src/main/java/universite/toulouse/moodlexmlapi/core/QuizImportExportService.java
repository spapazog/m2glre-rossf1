package universite.toulouse.moodlexmlapi.core;

import java.io.InputStream;
import java.io.OutputStream;

import universite.toulouse.moodlexmlapi.core.data.ImportedQuiz;
import universite.toulouse.moodlexmlapi.core.data.Quiz;

/**
 * Import export quiz service  
 * @author fsil
 *
 */
public interface QuizImportExportService {
	
	/**
	 * Import a quiz from a source formated in Moodle XML format
	 * @param is the input stream containing the quiz in Moodle XML format 
	 * @return the imported quiz
	 */
	public ImportedQuiz importQuiz(InputStream is) throws InvalidQuizFormatException, InvalidStreamSizeException;
	
	/**
	 * Export a quiz in the Moodle XML format
	 * @param quiz the quiz to export
	 * @return the output stream containing the quiz in Moodle XML format
	 */
	public OutputStream exportQuiz(Quiz quiz);

}
