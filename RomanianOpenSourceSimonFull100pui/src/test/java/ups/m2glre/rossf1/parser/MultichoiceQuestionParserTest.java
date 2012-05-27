package ups.m2glre.rossf1.parser;

import java.io.File;

import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import ups.m2glre.rossf1.question.MultichoiceQuestion;

public class MultichoiceQuestionParserTest extends TestCase{
    private MultichoiceQuestionParser multichoiceQuestionParser;
    private MultichoiceQuestion multichoiceQuestion;
    private Document document;

    public void setUp() {
        multichoiceQuestionParser = new MultichoiceQuestionParser();
        multichoiceQuestion = null;
        document = null;

        try {
            document = new SAXBuilder().build(new File("src/test/TestMultichoiceQuestion.xml"));
            multichoiceQuestion = (MultichoiceQuestion) multichoiceQuestionParser.
                    parseQuestion(document.getRootElement().getChild("question"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            fail();
        }
    }

    public void testAnswer() {
        assertEquals(4, multichoiceQuestion.getAnswers().size());
        assertEquals(33.333f, multichoiceQuestion.getAnswers().get(2).getFraction());
        assertEquals("Une architecture client serveur est une architecture N-tiers",
                multichoiceQuestion.getAnswers().get(1).getText());
    }
    public void testUnit() {
        assertEquals(false, multichoiceQuestion.isSingle());
    }
    public void testFeedback() {
        assertEquals("baz", multichoiceQuestion.getGeneralFeedBack());
        assertEquals("OK", multichoiceQuestion.getCorrectfeedbackText());
        assertEquals("P", multichoiceQuestion.getPartiallyfeedbackText());
        assertEquals("KO", multichoiceQuestion.getIncorrectfeedbackText());
        assertEquals("abc", multichoiceQuestion.getAnswernumbering());
    }
}
