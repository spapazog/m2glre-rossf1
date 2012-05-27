package ups.m2glre.rossf1.writer;

import org.jdom.Attribute;
import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.CalculatedQuestion;
import ups.m2glre.rossf1.question.internal.DataSetDefinition;
import ups.m2glre.rossf1.question.internal.DataSetItem;
import ups.m2glre.rossf1.question.internal.Unit;
import ups.m2glre.rossf1.utils.MoodleXML;
import ups.m2glre.rossf1.utils.WriterUtil;

/**
 * @author steeepph
 *
 */
public class CalculatedQuestionWriter extends QuestionWriter {
    public void writeSpecializedQuestion(Question question) {
        CalculatedQuestion q = (CalculatedQuestion) question;

        //Answer shuffle
        writeAnswerShuffle(q.isAnswerShuffle());

        //Answer
        Element answer = new Element(MoodleXML.TAG_ANSWER);
        answer.setAttribute(new Attribute(MoodleXML.TAG_FRACTION,
                String.valueOf(q.getAnswerFraction())));
        answer.addContent(WriterUtil.writeElement(
                MoodleXML.TAG_TEXT, String.valueOf(q.getAnswerTxt())));
        answer.addContent(WriterUtil.writeElement(
                MoodleXML.TAG_TOLERANCE, String.valueOf(q.getAnswerTolerance())));
        answer.addContent(WriterUtil.writeElement(
                MoodleXML.TAG_TOLERANCETYPE, String.valueOf(q.getAnswerToleranceType())));
        answer.addContent(WriterUtil.writeElement(
                MoodleXML.TAG_CORRECTANSWERFORMAT, String.valueOf(q.getAnswerCorrectAnswerFormat())));
        answer.addContent(WriterUtil.writeElement(
                MoodleXML.TAG_CORRECTANSWERLENGTH, String.valueOf(q.getAnswerCorrectAnswerLength())));
        answer.addContent(WriterUtil.writeElementWithText(
                MoodleXML.TAG_FEEDBACK, q.getAnswerFeedbackText()));
        questionXML.addContent(answer);

        //Units
        Element units = new Element(MoodleXML.TAG_UNITS);
        for (Unit u : q.getUnits()) {
            Element unit = new Element(MoodleXML.TAG_UNIT);

            unit.addContent(WriterUtil.writeElement(
                    MoodleXML.TAG_MULTIPLIER, String.valueOf(u.getMultiplier())));
            unit.addContent(WriterUtil.writeElement(
                    MoodleXML.TAG_NAME, u.getUnitName()));

            units.addContent(unit);
        }
        questionXML.addContent(units);

        //Dataset definition
        Element dsds = new Element(MoodleXML.TAG_DATASETDEFINITIONS);
        for (DataSetDefinition d : q.getDefinitions()) {
            Element dsd = new Element(MoodleXML.TAG_DATASETDEFINITION);

            //Status
            dsd.addContent(WriterUtil.
                    writeElementWithText(MoodleXML.TAG_STATUS, d.getStatus()));
            //Name
            dsd.addContent(WriterUtil.
                    writeElementWithText(MoodleXML.TAG_NAME, d.getName()));
            //Type
            dsd.addContent(WriterUtil.
                    writeElement(MoodleXML.TAG_TYPE, d.getType()));
            //Distribution
            dsd.addContent(WriterUtil.writeElementWithText(
                    MoodleXML.TAG_DISTRIBUTION, d.getDistribution()));
            //Minimum
            dsd.addContent(WriterUtil.writeElementWithText(
                    MoodleXML.TAG_MINIMUM, String.valueOf(d.getMinimum())));
            //Maximum
            dsd.addContent(WriterUtil.writeElementWithText(
                    MoodleXML.TAG_MAXIMUM, String.valueOf(d.getMaximum())));
            //Decimal
            dsd.addContent(WriterUtil.writeElementWithText(
                    MoodleXML.TAG_DECIMALS, String.valueOf(d.getDecimals())));
            //Item count
            dsd.addContent(WriterUtil.writeElement(
                    MoodleXML.TAG_ITEMCOUNT, String.valueOf(d.getItemCount())));

            //Dataset items
            Element dsis = new Element(MoodleXML.TAG_DATASETITEMS);
            for (DataSetItem ds : d.getItems()) {
                //Dataset item
                Element dsi = new Element(MoodleXML.TAG_DATASETITEM);
                dsi.addContent(WriterUtil.writeElement(
                        MoodleXML.TAG_NUMBER, String.valueOf(ds.getNumber())));
                dsi.addContent(WriterUtil.writeElement(
                        MoodleXML.TAG_VALUE, String.valueOf(ds.getValue())));
                dsis.addContent(dsi);
            }
            dsd.addContent(dsis);

            //Number items
            dsd.addContent(WriterUtil.writeElement(
                    MoodleXML.TAG_NB_ITEMS, String.valueOf(d.getItemCount())));

            dsds.addContent(dsd);
        }
        questionXML.addContent(dsds);
    }
}
