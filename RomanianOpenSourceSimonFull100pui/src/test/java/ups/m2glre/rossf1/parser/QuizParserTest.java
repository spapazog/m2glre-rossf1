package ups.m2glre.rossf1.parser;

import java.io.File;
import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import ups.m2glre.rossf1.quiz.ImportedQuizImpl;
import ups.m2glre.rossf1.quiz.QuizImpl;

public class QuizParserTest extends TestCase {
    private QuizImpl q;
    private ImportedQuizImpl iqi;
    private QuizParser qp;
    private Document document;

    public void setUp() {
        q = new QuizImpl();
        qp = new QuizParser();

        try {
            document = new SAXBuilder().build(new File("src/test/TestClozeQuestion.xml"));
            q = (QuizImpl) qp.parseQuiz(document.getRootElement());
            iqi = new ImportedQuizImpl(q);
        } catch (Exception e) {
            fail();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void testNbQuestion() {
        assertEquals(2, iqi.getProcessedQuestionCount());
    }
}
