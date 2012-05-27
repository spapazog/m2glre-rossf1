package ups.m2glre.rossf1.parser;

import java.io.File;
import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import ups.m2glre.rossf1.question.TrueFalseQuestion;

public class TrueFalseQuestionParserTest extends TestCase {
    private TrueFalseQuestionParser trueFalseQuestionParser;
    private TrueFalseQuestion trueFalseQuestion;
    private Document document;

    public void setUp() {
        trueFalseQuestionParser = new TrueFalseQuestionParser();
        trueFalseQuestion = null;
        document = null;

        try {
            document = new SAXBuilder().build(new File("src/test/TestTrueFalseQuestion.xml"));
            trueFalseQuestion = (TrueFalseQuestion) trueFalseQuestionParser.
                    parseQuestion(document.getRootElement().getChild("question"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            fail();
        }
    }
    public void testAnswer() {
        //1ere answer
        assertEquals(0f, trueFalseQuestion.getAnswers().get(0).getFraction());
        assertEquals("true", trueFalseQuestion.getAnswers().get(0).getText());
        assertEquals("Tomcat est un conteneur Web uniquement.", trueFalseQuestion.getAnswers().get(0).getFeedbackText());
        //2eme answer
        assertEquals(100f, trueFalseQuestion.getAnswers().get(1).getFraction());
        assertEquals("false", trueFalseQuestion.getAnswers().get(1).getText());
        assertEquals("Tomcat est un conteneur Web uniquement.", trueFalseQuestion.getAnswers().get(1).getFeedbackText());
    }
}
