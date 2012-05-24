package ups.m2glre.rossf1.parser;

import java.io.File;
import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import universite.toulouse.moodlexmlapi.core.data.QuestionTextFormat;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import ups.m2glre.rossf1.question.NumericalQuestion;

public class GenericQuestionParserTest extends TestCase {
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
        } catch (Exception e) {}
    }

    public void testQuestionName() {
        assertEquals("HTTP 1er protocole de l'Internet", numericalQuestion.getName());
    }
    public void testQuestionText() {
        assertEquals("En quelle année HTTP devient le premier protocole de l'Internet ?",
                numericalQuestion.getQuestionText().getText());
        assertEquals(QuestionTextFormat.moodle_auto_format,
                numericalQuestion.getQuestionText().getQuestionTextFormat());
    }
    public void testQuestionHidden() {
        assertEquals(Boolean.FALSE, numericalQuestion.isHidden());
    }
    public void testQuestionFeedback() {
        assertEquals("", numericalQuestion.getGeneralFeedBack());
    }
    public void testQuestionPenalty() {
        assertEquals(0.1f, numericalQuestion.getPenalty());
    }
    public void testQuestionGrade() {
        assertEquals(1f, numericalQuestion.getDefaultGrade());
    }
    public void testQuestionType() {
        assertEquals(QuestionType.numerical, numericalQuestion.getQuestionType());
    }
}
