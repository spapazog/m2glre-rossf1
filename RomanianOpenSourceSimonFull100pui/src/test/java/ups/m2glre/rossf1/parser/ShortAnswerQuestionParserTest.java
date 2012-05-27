package ups.m2glre.rossf1.parser;

import java.io.File;
import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import ups.m2glre.rossf1.question.ShortAnswerQuestion;
import ups.m2glre.rossf1.question.internal.Answer;

public class ShortAnswerQuestionParserTest extends TestCase {
    private ShortAnswerQuestionParser shortAnswerQuestionParser;
    private ShortAnswerQuestion shortAnswerQuestion;
    private Document document;

    public void setUp() {
        shortAnswerQuestionParser = new ShortAnswerQuestionParser();
        shortAnswerQuestion = null;
        document = null;

        try {
            document = new SAXBuilder().build(new File("src/test/TestShortAnswerQuestion.xml"));
            shortAnswerQuestion = (ShortAnswerQuestion) shortAnswerQuestionParser.
                    parseQuestion(document.getRootElement().getChild("question"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            fail();
        }
    }

    public void testUsecase() {
        assertEquals(0, shortAnswerQuestion.getUseCase());
    }
    public void testAnswer() {
        //1ere answer
        assertEquals(100f, shortAnswerQuestion.getAnswers().get(0).getFraction());
        assertEquals("Simula 66", shortAnswerQuestion.getAnswers().get(0).getText());
        assertEquals("Parfait !", shortAnswerQuestion.getAnswers().get(0).getFeedbackText());
        //2eme answer
        assertEquals(75f, shortAnswerQuestion.getAnswers().get(1).getFraction());
        assertEquals("Simula", shortAnswerQuestion.getAnswers().get(1).getText());
        assertEquals("Oui, plus précisément Simula 66", shortAnswerQuestion.getAnswers().get(1).getFeedbackText());
    }
}
