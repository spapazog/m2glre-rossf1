package ups.m2glre.rossf1.quiz;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import junit.framework.TestCase;

public class ImportExportTest extends TestCase {
    private QuizServiceImpl quizService;

    public void setUp() {
        quizService = new QuizServiceImpl();
    }

    public void testImportQuiz() {
        try {
            ImportedQuizImpl quiz = (ImportedQuizImpl) quizService.importQuiz(new FileInputStream("src/test/TestFull.xml"));
            assertEquals(10, quiz.getExtractedQuestionCount());

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    public void testImportQuiz2() {
        try {
            FileInputStream is = new FileInputStream("src/test/TestQuiz2.xml");
            ImportedQuizImpl quiz = (ImportedQuizImpl) quizService.importQuiz(is);
            assertEquals(26, quiz.getExtractedQuestionCount());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    public void testImportExportQuiz1() {
        try {
            FileInputStream is = new FileInputStream("src/test/TestFull.xml");
            ImportedQuizImpl quiz = (ImportedQuizImpl) quizService.importQuiz(is);
            assertEquals(10, quiz.getExtractedQuestionCount());

            // open streams
            FileInputStream is2 = new FileInputStream("src/test/TestFull.xml");
            OutputStream os = quizService.exportQuiz(quiz);
            os.close();
            FileInputStream isRes = new FileInputStream("target/export.xml");

            assertEquals(is2.available(), isRes.available());

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    public void testImportExportQuiz2() {
        try {
            FileInputStream is = new FileInputStream("src/test/TestQuiz2.xml");
            ImportedQuizImpl quiz = (ImportedQuizImpl) quizService.importQuiz(is);
            assertEquals(26, quiz.getExtractedQuestionCount());

            // open streams
            FileInputStream is2 = new FileInputStream("src/test/TestQuiz2.xml");
            OutputStream os = quizService.exportQuiz(quiz);
            os.close();
            FileInputStream isRes = new FileInputStream("target/export.xml");

            assertEquals(is2.available(), isRes.available());

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    /*private void compareStream(InputStream is, InputStream isRes) {
        byte[] bufferIs = new byte[100];
        byte[] bufferIsRes = new byte[100];

        try {
            while ((is.read(bufferIs) == 100) && (isRes.read(bufferIsRes) == 100)) {
                for (int i = 0 ; i < 100 ; i++) {
                    if (bufferIs[i] != bufferIsRes[i])
                        fail("Different buffer content "+bufferIs[i]+ bufferIsRes[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }*/
}
