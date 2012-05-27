package ups.m2glre.rossf1.writer;

import java.io.File;
import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import ups.m2glre.rossf1.parser.QuizParser;
import ups.m2glre.rossf1.quiz.QuizImpl;
import ups.m2glre.rossf1.writer.QuizWriter;

public class QuizWriterTest extends TestCase {
    private QuizImpl q;
    private QuizParser qp;
    private Document document;

    public void testWriter() {
        q = new QuizImpl();
        qp = new QuizParser();

        try {
            document = new SAXBuilder().build(new File("src/test/TestCalculatedQuestion.xml"));
            q = (QuizImpl) qp.parseQuiz(document.getRootElement());
            new QuizWriter(q).getOutputStream();
        } catch (Exception e) {
            fail();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
