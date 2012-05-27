package ups.m2glre.rossf1.writer;

import org.jdom.Attribute;
import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.NumericalQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;

/**
 * @author steeepph
 *
 */
public class NumericalQuestionWriter extends QuestionWriter {
    public void writeSpecializedQuestion(Question question) {
        NumericalQuestion q = (NumericalQuestion) question;

        //Answer
        Element answer = new Element(MoodleXML.TAG_ANSWER);
        answer.setAttribute(new Attribute(MoodleXML.TAG_FRACTION,
                String.valueOf(q.getAnswerFraction())));
        Element answerText = new Element(MoodleXML.TAG_TEXT);
        answerText.setText(String.valueOf(q.getAnswerValue()));
        Element answerTolerance = new Element(MoodleXML.TAG_TOLERANCE);
        answerTolerance.setText(String.valueOf(q.getAnswerTolerence()));
        Element answerFeedback = new Element(MoodleXML.TAG_FEEDBACK);
        Element answerFeedbackText = new Element(MoodleXML.TAG_TEXT);
        answerFeedbackText.setText(q.getFeedbackText());
        answerFeedback.addContent(answerFeedbackText);
        answer.addContent(answerText);
        answer.addContent(answerTolerance);
        answer.addContent(answerFeedback);
        questionXML.addContent(answer);

        //Units
        Element units = new Element(MoodleXML.TAG_UNITS);
        Element unit = new Element(MoodleXML.TAG_UNIT);
        Element unitMulti = new Element(MoodleXML.TAG_MULTIPLIER);
        unitMulti.setText(String.valueOf(q.getUnit().getMultiplier()));
        Element unitName = new Element(MoodleXML.TAG_UNIT_NAME);
        unitName.setText(String.valueOf(q.getUnit().getUnitName()));
        unit.addContent(unitMulti);
        unit.addContent(unitName);
        units.addContent(unit);
        questionXML.addContent(units);

        //Answers shuffle
        writeAnswerShuffle(q.isAnswerShuffle());
    }
}
