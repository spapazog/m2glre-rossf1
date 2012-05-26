package ups.m2glre.rossf1.writer;

import java.io.File;
import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import ups.m2glre.rossf1.parser.QuizParser;
import ups.m2glre.rossf1.question.CategoryQuestion;
import ups.m2glre.rossf1.quiz.ImportedQuizImpl;
import ups.m2glre.rossf1.quiz.QuizImpl;
import ups.m2glre.rossf1.writer.QuizWriter;

public class QuizWriterTest extends TestCase {
    private QuizImpl q;
    private ImportedQuizImpl iqi;
    private QuizParser qp;
    private Document document;

    public void setUp() {
        
        q = new QuizImpl();
        qp = new QuizParser();

        try {
            document = new SAXBuilder().build(new File("src/test/TestFull.xml"));
            q = (QuizImpl) qp.parseQuiz(document.getRootElement());
            
            new QuizWriter(q).getOutputStream();
            
        } catch (Exception e) {
            fail();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void testNbQuestion() {
        
    }
}
