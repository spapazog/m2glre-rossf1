package ups.m2glre.rossf1.parser;

import java.io.File;
import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import ups.m2glre.rossf1.question.CategoryQuestion;

public class CategoryQuestionParserTest extends TestCase {
    private CategoryQuestionParser categoryQuestionParser;
    private CategoryQuestion categoryQuestion;
    private Document document;

    public void setUp() {
        categoryQuestionParser = new CategoryQuestionParser();
        categoryQuestion = null;
        document = null;

        try {
            document = new SAXBuilder().build(new File("src/test/quiz-exemple-20120229-0812.xml"));
            categoryQuestion = (CategoryQuestion) categoryQuestionParser.
                    parseQuestion(document.getRootElement().getChild("question"));
        } catch (Exception e) {
            fail();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void testCategoryText() {
        assertEquals("$course$/Défaut pour 1SA3GL1", categoryQuestion.getCategoryText());
    }
}
