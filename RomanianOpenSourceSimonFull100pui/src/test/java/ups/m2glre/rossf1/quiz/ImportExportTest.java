package ups.m2glre.rossf1.quiz;

import java.io.FileInputStream;
import java.io.OutputStream;

import junit.framework.TestCase;

public class ImportExportTest extends TestCase {
    private QuizServiceImpl quizService;

    public void setUp() {
        quizService = new QuizServiceImpl();
    }

    public void testImportQuizFull() {
        try {
            ImportedQuizImpl quiz = (ImportedQuizImpl) quizService.importQuiz(new FileInputStream("src/test/TestFull.xml"));
            assertEquals(10, quiz.getExtractedQuestionCount());

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    public void testImportQuiz() {
        try {
            FileInputStream is = new FileInputStream("src/test/TestQuiz.xml");
            ImportedQuizImpl quiz = (ImportedQuizImpl) quizService.importQuiz(is);
            assertEquals(26, quiz.getExtractedQuestionCount());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    public void testImportExportQuiz() {
        try {
            /*
             * Test import de quiz à partir d'un fichier
             */
            FileInputStream is = new FileInputStream("src/test/TestQuiz.xml");
            ImportedQuizImpl quiz = (ImportedQuizImpl) quizService.importQuiz(is);
            assertEquals(26, quiz.getExtractedQuestionCount());

            /*
             * Test d'export de quiz
             */
            //Ouverture du fichier pour enregistrement dans Quiz
            is = new FileInputStream("src/test/TestQuiz.xml");
            quiz = (ImportedQuizImpl) quizService.importQuiz(is);
            //Création du fichier exporté (export.xml) à partir du quiz importé
            OutputStream os = quizService.exportQuiz(quiz);
            os.close();
            //Ré-ouveture du fichier crée
            FileInputStream isRes = new FileInputStream("target/export.xml");
            quiz = (ImportedQuizImpl) quizService.importQuiz(isRes);
            //Vérification du nombre de question
            assertEquals(26, quiz.getExtractedQuestionCount());

            //assertEquals(is2.available(), isRes.available());

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
