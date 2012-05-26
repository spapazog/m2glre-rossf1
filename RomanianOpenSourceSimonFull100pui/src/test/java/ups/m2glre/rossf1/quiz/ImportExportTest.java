package ups.m2glre.rossf1.quiz;

import java.io.FileInputStream;

import junit.framework.TestCase;

import ups.m2glre.rossf1.quiz.ImportedQuizImpl;
import ups.m2glre.rossf1.quiz.QuizServiceImpl;

public class ImportExportTest extends TestCase {
    private QuizServiceImpl quizService;

    public void setUp() {
        quizService = new QuizServiceImpl();
    }

    public void testImportQuiz() {
        try {
            ImportedQuizImpl quiz = (ImportedQuizImpl) quizService.importQuiz(new FileInputStream("src/test/TestFull.xml"));
            assertEquals(7, quiz.getExtractedQuestionCount());
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }
    }
    public void testExportQuiz() {
    }
}
