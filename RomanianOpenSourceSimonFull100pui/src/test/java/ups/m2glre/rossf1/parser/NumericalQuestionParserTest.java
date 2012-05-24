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
            assertEquals(document.getRootElement().getName(), "quiz");

            numericalQuestion = (NumericalQuestion) numericalQuestionParser.
                    parseQuestion(
                            document.getRootElement().getChild("question"));
            assertNotNull(numericalQuestion);
        } catch (Exception e) {}
    }

    public void testAnswer() {
        assertEquals(100, numericalQuestion.getAnswerFraction());
        assertEquals(0, numericalQuestion.getAnswerTolerence());
        assertEquals(1996, numericalQuestion.getAnswerValue());
        assertEquals(false, numericalQuestion.isAnswerShuffle());
    }
    public void testUnit() {
        assertEquals("annee", numericalQuestion.getAnswerUnitName());
        assertEquals(1, numericalQuestion.getAnswerUnitMultiplier());
    }
    public void testFeedback() {
        assertEquals("yo", numericalQuestion.getFeedbackText());
    }
}
