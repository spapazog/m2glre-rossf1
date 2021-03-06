package ups.m2glre.rossf1.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Element;

import ups.m2glre.rossf1.question.CalculatedQuestion;
import ups.m2glre.rossf1.question.internal.DataSetDefinition;
import ups.m2glre.rossf1.question.internal.DataSetItem;
import ups.m2glre.rossf1.question.internal.Unit;
import ups.m2glre.rossf1.utils.MoodleXML;
import ups.m2glre.rossf1.utils.ParserUtil;

/**
 * Calculated Question Parser.
 *
 */
public class CalculatedQuestionParser extends QuestionParser  {
    /**
     * CalculatedQuestion object representation.
     */
    private CalculatedQuestion calculatedQuestion;

    /**
     * Parser of the specialized nodes for CalculatedQuestion.
     * @param questionElement node element of the question
     * @throws exception if the format of the XML is not valid
     */
    @Override
    public final void parseSpecializedQuestion(Element questionElement)
            throws Throwable {

        calculatedQuestion = (CalculatedQuestion) question;

        //parse answer shuffle
        boolean answerShuffle = parseAnswerShuffle(questionElement);

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
        calculatedQuestion.setAnswerShuffle(answerShuffle);
        calculatedQuestion.setAnswerFraction(answerFraction);
        calculatedQuestion.setAnswerTxt(answerText);
        calculatedQuestion.setAnswerTolerance(tolerance);
        calculatedQuestion.setAnswerToleranceType(toleranceType);
        calculatedQuestion.setAnswerCorrectAnswerFormat(correctAnswerFormat);
        calculatedQuestion.setAnswerCorrectAnswerLength(correctAnswerLength);
        calculatedQuestion.setAnswerFeedbackText(feedBack);

        Element unitsElement = ParserUtil.getElement(questionElement, MoodleXML.TAG_UNITS);
        List<Unit> units = ParserUtil.getUnits(unitsElement);
        calculatedQuestion.setUnits(units);

        Element dsdElement = ParserUtil.getElement(questionElement, MoodleXML.TAG_DATASETDEFINITIONS);
        parseDataSetDefinitions(dsdElement);

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
