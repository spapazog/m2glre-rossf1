package ups.m2glre.rossf1.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.CalculatedQuestion;
import ups.m2glre.rossf1.question.DataSetDefinition;
import ups.m2glre.rossf1.question.DataSetItem;
import ups.m2glre.rossf1.utils.MoodleXML;
import ups.m2glre.rossf1.utils.ParserUtil;

/** Culculated question parser
 * XML representation is :
 *     <question type="calculated">
        <!-- generic fields -->
        <shuffleanswers>0</shuffleanswers>
        <answer fraction="100">
            <text>3.14 * {R}*{R}</text>
            <tolerance>0.01</tolerance>
            <tolerancetype>1</tolerancetype>
            <correctanswerformat>1</correctanswerformat>
            <correctanswerlength>1</correctanswerlength>
            <feedback>
                <text></text>
            </feedback>
        </answer>
        <units>
            <unit>
                <multiplier>1</multiplier>
                <unit_name>m2</unit_name>
            </unit>
        </units>
        <dataset_definitions>
            <dataset_definition>
                <status>
                    <text>shared</text>
                </status>
                <name>
                    <text>R</text>
                </name>
                <type>calculated</type>
                <distribution>
                    <text>uniform</text>
                </distribution>
                <minimum>
                    <text>1.0</text>
                </minimum>
                <maximum>
                    <text>10.0</text>
                </maximum>
                <decimals>
                    <text>1</text>
                </decimals>
                <itemcount>10</itemcount>
                <dataset_items>
                    <dataset_item>
                        <number>1</number>
                        <value>6.9</value>
                    </dataset_item>
                    <dataset_item>
                        <number>2</number>
                        <value>9.7</value>
                    </dataset_item>
                    <dataset_item>
                        <number>3</number>
                        <value>5.2</value>
                    </dataset_item>
                    <dataset_item>
                        <number>4</number>
                        <value>7.1</value>
                    </dataset_item>
                    <dataset_item>
                        <number>5</number>
                        <value>4.8</value>
                    </dataset_item>
                    <dataset_item>
                        <number>6</number>
                        <value>6.0</value>
                    </dataset_item>
                    <dataset_item>
                        <number>7</number>
                        <value>6.3</value>
                    </dataset_item>
                    <dataset_item>
                        <number>8</number>
                        <value>5.0</value>
                    </dataset_item>
                    <dataset_item>
                        <number>9</number>
                        <value>6.2</value>
                    </dataset_item>
                    <dataset_item>
                        <number>10</number>
                        <value>2.6</value>
                    </dataset_item>
                </dataset_items>
                <number_of_items>10</number_of_items>
            </dataset_definition>
        </dataset_definitions>
    </question>
 */
public class CalculatedQuestionParser extends QuestionParser  {

    private CalculatedQuestion calculatedQuestion;

    @Override
    public final void parseSpecializedQuestion(Element questionElement)
            throws InvalidQuizFormatException {

        calculatedQuestion = (CalculatedQuestion) question;

        try {
            // parse answer node
            Element answerElement = ParserUtil.getElement(questionElement, MoodleXML.TAG_ANSWER);

            int answerFraction = ParserUtil.getAttributeInt(answerElement, MoodleXML.TAG_FRACTION);
            String answerText = ParserUtil.getElementText(answerElement, MoodleXML.TAG_TEXT);
            float tolerance = ParserUtil.getElementFloat(answerElement, MoodleXML.TAG_TOLERANCE);
            int toleranceType = ParserUtil.getElementInt(answerElement, MoodleXML.TAG_TOLERANCETYPE);
            int correctAnswerFormat = ParserUtil.getElementInt(answerElement, MoodleXML.TAG_CORRECTANSWERFORMAT);
            int correctAnswerLength = ParserUtil.getElementInt(answerElement, MoodleXML.TAG_CORRECTANSWERLENGTH);
            String feedBack = ParserUtil.getElementText(
                    ParserUtil.getElement(answerElement, MoodleXML.TAG_FEEDBACK),
                    MoodleXML.TAG_TEXT);

            // add to Object
            calculatedQuestion.setAnswerFraction(answerFraction);
            calculatedQuestion.setAnswerTxt(answerText);
            calculatedQuestion.setAnswerTolerance(tolerance);
            calculatedQuestion.setAnswerToleranceType(toleranceType);
            calculatedQuestion.setAnswerCorrectAnswerFormat(correctAnswerFormat);
            calculatedQuestion.setAnswerCorrectAnswerLength(correctAnswerLength);
            calculatedQuestion.setAnswerFeedbackText(feedBack);

            Element unitsElement = ParserUtil.getElement(questionElement, MoodleXML.TAG_UNITS);
            parseUnits(unitsElement);

            Element dsdElement = ParserUtil.getElement(questionElement, MoodleXML.TAG_DATASETDEFINITIONS);
            parseDataSetDefinitions(dsdElement);

        } catch (Throwable t) {
            throw new InvalidQuizFormatException(t);
        }

    }

    private void parseUnits(Element unitsElement) throws Throwable {
        List<Element> units = unitsElement.getChildren(MoodleXML.TAG_UNIT);
        Iterator i = units.iterator();

        while (i.hasNext()) {
            Element unitElement = (Element) i.next();

            int multiplier = ParserUtil.getElementInt(unitElement, MoodleXML.TAG_MULTIPLIER);
            String unitName = ParserUtil.getElementText(unitElement, MoodleXML.TAG_UNIT_NAME);

            calculatedQuestion.addUnit(multiplier, unitName);
        }
        
        
    }

    private void parseDataSetDefinitions(Element dsdElement) throws Throwable {
        List<Element> dataSetDefinitions = dsdElement.getChildren(MoodleXML.TAG_DATASETDEFINITION);
        Iterator i = dataSetDefinitions.iterator();

        while (i.hasNext()) {
            Element dataSetDefinitionElement = (Element) i.next();

            String status = ParserUtil.getElementText(
                    ParserUtil.getElement(dataSetDefinitionElement, MoodleXML.TAG_STATUS),
                    MoodleXML.TAG_TEXT);

            String name = ParserUtil.getElementText(
                    ParserUtil.getElement(dataSetDefinitionElement, MoodleXML.TAG_NAME),
                    MoodleXML.TAG_TEXT);

            String type = ParserUtil.getElementText(dataSetDefinitionElement, MoodleXML.TAG_TYPE);
            String distribution = ParserUtil.getElementText(
                    ParserUtil.getElement(dataSetDefinitionElement, MoodleXML.TAG_DISTRIBUTION),
                    MoodleXML.TAG_TEXT);
            float minimum = ParserUtil.getElementFloat(
                    ParserUtil.getElement(dataSetDefinitionElement, MoodleXML.TAG_MINIMUM),
                    MoodleXML.TAG_TEXT);
            float maximum = ParserUtil.getElementFloat(
                    ParserUtil.getElement(dataSetDefinitionElement, MoodleXML.TAG_MAXIMUM),
                    MoodleXML.TAG_TEXT);
            int decimals = ParserUtil.getElementInt(
                    ParserUtil.getElement(dataSetDefinitionElement, MoodleXML.TAG_DECIMALS),
                    MoodleXML.TAG_TEXT);

            DataSetDefinition dataSetDefinition  = new DataSetDefinition();
            dataSetDefinition.setStatus(status);
            dataSetDefinition.setName(name);
            dataSetDefinition.setType(type);
            dataSetDefinition.setDistribution(distribution);
            dataSetDefinition.setMinimum(minimum);
            dataSetDefinition.setMaximum(maximum);
            dataSetDefinition.setDecimals(decimals);

            Element dsiElement = ParserUtil.getElement(dataSetDefinitionElement, MoodleXML.TAG_DATASETITEMS);
            List<DataSetItem> items = parseDataSetItems(dsiElement);
            dataSetDefinition.setItem(items);

            calculatedQuestion.addDefinition(dataSetDefinition);

        }
    }

    private List<DataSetItem> parseDataSetItems(Element dsiElement) throws Throwable {
        List<Element> units = dsiElement.getChildren(MoodleXML.TAG_DATASETITEM);
        Iterator i = units.iterator();

        List<DataSetItem> items = new ArrayList<DataSetItem>();

        while (i.hasNext()) {
            Element itemEment = (Element) i.next();

            int number = ParserUtil.getElementInt(itemEment, MoodleXML.TAG_NUMBER);
            float value = ParserUtil.getElementFloat(itemEment, MoodleXML.TAG_VALUE);

            DataSetItem item = new DataSetItem(number, value);
            items.add(item);
        }

        return items;
    }
}
