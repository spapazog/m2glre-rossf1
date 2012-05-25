package ups.m2glre.rossf1.parser;

import java.io.File;
import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import ups.m2glre.rossf1.question.DescriptionQuestion;

public class DescriptionQuestionParserTest extends TestCase {
    private DescriptionQuestionParser descriptionQuestionParser;
    private DescriptionQuestion descriptionQuestion;
    private Document document;

    public void setUp() {
        descriptionQuestionParser = new DescriptionQuestionParser();
        descriptionQuestion = null;
        document = null;

        try {
            document = new SAXBuilder().build(new File("src/test/TestDescriptionQuestion.xml"));
            descriptionQuestion = (DescriptionQuestion) descriptionQuestionParser.
                    parseQuestion(document.getRootElement().getChild("question"));
        } catch (Exception e) {
            fail();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void testQuestionName() {
        assertEquals("Consigne dispositif électronique", descriptionQuestion.getName());
    }
    public void testQuestionType() {
        assertEquals(QuestionType.description, descriptionQuestion.getQuestionType());
    }
    public void testQuestionShuffle() {
        assertFalse(descriptionQuestion.isAnswerShuffle());
    }
}
