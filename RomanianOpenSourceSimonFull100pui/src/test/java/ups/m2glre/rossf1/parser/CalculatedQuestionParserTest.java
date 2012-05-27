package ups.m2glre.rossf1.parser;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.CalculatedQuestion;
import ups.m2glre.rossf1.question.internal.DataSetDefinition;
import ups.m2glre.rossf1.question.internal.DataSetItem;
import ups.m2glre.rossf1.question.internal.Unit;

public class CalculatedQuestionParserTest extends TestCase {
    CalculatedQuestion calculatedQuestion;

    public void testFile1() {
        try {
            calculatedQuestion = (CalculatedQuestion) loadFile("src/test/TestCalculatedQuestion.xml");

            assertEquals(100, calculatedQuestion.getAnswerFraction());
            assertEquals("3.14 * {R}*{R}", calculatedQuestion.getAnswerTxt());
            assertEquals(0.01, calculatedQuestion.getAnswerTolerance(), 0.0001);
            assertEquals(1, calculatedQuestion.getAnswerToleranceType());
            assertEquals(1, calculatedQuestion.getAnswerCorrectAnswerFormat());
            assertEquals(1, calculatedQuestion.getAnswerCorrectAnswerLength());
            assertEquals("", calculatedQuestion.getAnswerFeedbackText());

            // test units
            List<Unit> units = calculatedQuestion.getUnits();
            Integer multiplier = units.get(0).getMultiplier();
            String unitName = units.get(0).getUnitName();
            assertEquals(multiplier, new Integer(1));
            assertEquals(unitName, "m2");

            // test DataSetDefinitions
            List<DataSetDefinition> definitions = calculatedQuestion.getDefinitions();
            DataSetDefinition def = definitions.get(0);
            assertEquals("shared", def.getStatus());
            assertEquals("R", def.getName());
            assertEquals("calculated", def.getType());
            assertEquals("uniform", def.getDistribution());
            assertEquals(1.0, def.getMinimum(), 0.001);
            assertEquals(10.0, def.getMaximum(), 0.001);
            assertEquals(1, def.getDecimals());
            assertEquals(10, def.getItemCount());

            //test DataSetItems
            List<DataSetItem> items = def.getItems();
            assertEquals(10, items.size());

            for (int i = 0 ; i < 10 ; i++) {
                assertEquals(i+1, items.get(i).getNumber());
            }
            assertEquals(6.9, items.get(0).getValue(), 0.001);
            assertEquals(9.7, items.get(1).getValue(), 0.001);
            assertEquals(5.2, items.get(2).getValue(), 0.001);
            assertEquals(7.1, items.get(3).getValue(), 0.001);
            assertEquals(4.8, items.get(4).getValue(), 0.001);
            assertEquals(6.0, items.get(5).getValue(), 0.001);
            assertEquals(6.3, items.get(6).getValue(), 0.001);
            assertEquals(5.0, items.get(7).getValue(), 0.001);
            assertEquals(6.2, items.get(8).getValue(), 0.001);
            assertEquals(2.6, items.get(9).getValue(), 0.001);


        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
            e.printStackTrace();
            fail();
        }

    }

    private Question loadFile(String fileName) throws Exception {
        Element questionElement = null;
        Question question = null;

        Document document = new SAXBuilder().build(new File(fileName));
        questionElement = document.getRootElement().getChild("question");
        question = getParser(questionElement).parseQuestion(questionElement);

        return question;
    }

    private QuestionParser getParser(Element xml) throws Exception {
        return QuestionParserFactory.getQuestionParser(xml);
    }

}
