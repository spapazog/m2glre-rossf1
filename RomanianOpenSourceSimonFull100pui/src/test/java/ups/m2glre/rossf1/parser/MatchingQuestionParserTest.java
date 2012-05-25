package ups.m2glre.rossf1.parser;

import java.io.File;
import java.util.HashMap;

import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import ups.m2glre.rossf1.question.MatchingQuestion;

public class MatchingQuestionParserTest extends TestCase {
        private MatchingQuestionParser matchingQuestionParser;
        private MatchingQuestion matchingQuestion;
        private Document document;

        public void setUp() {
            matchingQuestionParser = new MatchingQuestionParser();
            matchingQuestion = null;
            document = null;

            try {
                document = new SAXBuilder().build(new File("src/test/TestPairMatchingQuestion.xml"));
                matchingQuestion = (MatchingQuestion) matchingQuestionParser.
                    parseQuestion(document.getRootElement().getChild("question"));
                } catch (Exception e) { fail();
                System.out.println(e.getMessage());
                e.printStackTrace();}
        }

        public void testSubquestion() {
            HashMap<String, String>  subQuestions = matchingQuestion.getSubquestion();

            for (String key : subQuestions.keySet()) {

                if (key.equals("JBOSS")) {
                    assertEquals("JBOSS",key);
                    assertEquals("Redhat",subQuestions.get(key));
                }
                else if (key.equals("Websphere")) {
                    assertEquals("Websphere",key);
                    assertEquals("IBM",subQuestions.get(key));
                }
                else {
                    fail();
                }

            }
            assertEquals(false, matchingQuestion.isSuffleAnswer());
        }

}
