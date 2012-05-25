package ups.m2glre.rossf1.parser;

import java.io.File;

import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
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
            fail();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void testAnswer() {
        assertEquals(0, multichoiceQuestion.getAnswerFraction());
        assertEquals("foo", multichoiceQuestion.getAnswerText());
        assertEquals(true, multichoiceQuestion.isAnswerShuffle());
    }
    public void testUnit() {
        assertEquals(false, multichoiceQuestion.isSingle());
    }
    public void testFeedback() {
        assertEquals("bar", multichoiceQuestion.getFeedbackText());
        assertEquals("baz", multichoiceQuestion.getGeneralFeedBack());
        assertEquals("OK", multichoiceQuestion.getCorrectfeedbackText());
        assertEquals("P", multichoiceQuestion.getPartiallyfeedbackText());
        assertEquals("KO", multichoiceQuestion.getIncorrectfeedbackText());
        assertEquals("abc", multichoiceQuestion.getAnswernumbering());
    }
}
