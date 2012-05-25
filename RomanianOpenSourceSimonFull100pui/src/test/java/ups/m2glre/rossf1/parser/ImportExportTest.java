package ups.m2glre.rossf1.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import universite.toulouse.moodlexmlapi.core.InvalidStreamSizeException;
import universite.toulouse.moodlexmlapi.core.data.ImportedQuiz;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import universite.toulouse.moodlexmlapi.core.data.Quiz;
import ups.m2glre.rossf1.question.CategoryQuestion;
import ups.m2glre.rossf1.quiz.ImportedQuizImpl;
import ups.m2glre.rossf1.quiz.QuizImpl;
import ups.m2glre.rossf1.quiz.QuizServiceImpl;

public class ImportExportTest extends TestCase {
    private QuizServiceImpl quizService;
    private ImportedQuizImpl quiz;

    public void setUp() {
        quizService = new QuizServiceImpl();

        try {
            quiz = (ImportedQuizImpl) quizService.importQuiz(new FileInputStream("src/test/TestClozeQuestion.xml"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidQuizFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidStreamSizeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void testNbQuestion() {
        assertEquals(2, quiz.getExtractedQuestionCount());
    }
}
