package ups.m2glre.rossf1.parser;

import java.io.File;
import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import ups.m2glre.rossf1.question.NumericalQuestion;

public class NumericalQuestionParserTest extends TestCase {
    private NumericalQuestionParser numericalQuestionParser;
    private NumericalQuestion numericalQuestion;
    private Document document;

    public void setUp() {
        numericalQuestionParser = new NumericalQuestionParser();
        numericalQuestion = null;
        document = null;

        try {
            document = new SAXBuilder().build(new File("src/test/TestNumericalQuestion.xml"));
            numericalQuestion = (NumericalQuestion) numericalQuestionParser.
                    parseQuestion(document.getRootElement().getChild("question"));
        } catch (Exception e) {
            fail();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void testAnswer() {
        assertEquals(100, numericalQuestion.getAnswerFraction());
        assertEquals(0, numericalQuestion.getAnswerTolerence());
        assertEquals(1996, numericalQuestion.getAnswerValue());
        assertEquals(false, numericalQuestion.isAnswerShuffle());
    }
    public void testUnit() {
        assertEquals("annee", numericalQuestion.getUnit().getUnitName());
        assertEquals(1, numericalQuestion.getUnit().getMultiplier());
    }
    public void testFeedback() {
        assertEquals("yo", numericalQuestion.getFeedbackText());
    }
}
