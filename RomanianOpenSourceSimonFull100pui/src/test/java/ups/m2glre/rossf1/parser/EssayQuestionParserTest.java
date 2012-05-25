package ups.m2glre.rossf1.parser;

import java.io.File;
import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import ups.m2glre.rossf1.question.EssayQuestion;

public class EssayQuestionParserTest extends TestCase {
    private EssayQuestionParser essayQuestionParser;
    private EssayQuestion essayQuestion;
    private Document document;

    public void setUp() {
        essayQuestionParser = new EssayQuestionParser();
        essayQuestion = null;
        document = null;

        try {
            document = new SAXBuilder().build(new File("src/test/TestEssayQuestion.xml"));
            essayQuestion = (EssayQuestion) essayQuestionParser.
                    parseQuestion(document.getRootElement().getChild("question"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            fail();
        }
    }

    public void testAnswerFraction() {
        assertEquals(0, essayQuestion.getAnswerFraction());
    }

    public void testFeedbackText() {
        assertEquals("Feedback test", essayQuestion.getAnswerValue());
    }
}
