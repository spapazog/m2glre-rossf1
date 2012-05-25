package ups.m2glre.rossf1.parser;

import java.io.File;
import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import ups.m2glre.rossf1.question.ClozeQuestion;

public class ClozeQuestionParserTest extends TestCase {
    private ClozeQuestionParser ClozeQuestionParser;
    private ClozeQuestion ClozeQuestion;
    private Document document;

    public void setUp() {
        ClozeQuestionParser = new ClozeQuestionParser();
        ClozeQuestion = null;
        document = null;

        try {
            document = new SAXBuilder().build(new File("src/test/TestClozeQuestion.xml"));
            ClozeQuestion = (ClozeQuestion) ClozeQuestionParser.
                    parseQuestion(document.getRootElement().getChild("question"));
        } catch (Exception e) {
            fail();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void testQuestionName() {
        assertTrue(ClozeQuestion.getQuestionText().getText().startsWith(
                "Cette question comporte du texte dans lequel on a directement"));
    }
    public void testQuestionType() {
        assertEquals(QuestionType.cloze, ClozeQuestion.getQuestionType());
    }
    public void testQuestionShuffle() {
        assertFalse(ClozeQuestion.isAnswerShuffle());
    }
}
