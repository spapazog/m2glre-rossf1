package ups.m2glre.rossf1.parser;

import java.util.List;

import org.jdom.Element;

import ups.m2glre.rossf1.question.NumericalQuestion;
import ups.m2glre.rossf1.question.internal.Unit;
import ups.m2glre.rossf1.utils.MoodleXML;
import ups.m2glre.rossf1.utils.ParserUtil;

public class NumericalQuestionParser extends QuestionParser {

    public void parseSpecializedQuestion(Element questionXML)
            throws Throwable {
        NumericalQuestion q = (NumericalQuestion) question;

        Element answerElement = ParserUtil.getElement(questionXML, MoodleXML.TAG_ANSWER);
        //Parse la fraction
        q.setAnswerFraction(ParserUtil.getAttributeInt(answerElement, MoodleXML.TAG_FRACTION));
        //Parse la valeur
        q.setAnswerValue(ParserUtil.getElementInt(answerElement, MoodleXML.TAG_TEXT));
        //Parse le feedback text
                q.setFeedbackText(ParserUtil.getElementText(
                        ParserUtil.getElement(answerElement, MoodleXML.TAG_FEEDBACK),
                        MoodleXML.TAG_TEXT));
        //Parse la tolerence
        q.setAnswerTolerence(ParserUtil.getElementInt(answerElement, MoodleXML.TAG_TOLERANCE));
        //Parse l'unité
        List<Unit> units = ParserUtil.getUnits(ParserUtil.getElement(questionXML, MoodleXML.TAG_UNITS));
        if (units.size() != 1)
            throw new Throwable(MoodleXML.TAG_UNITS + "node in numericalQuestion should contains one unit");
        q.setUnit(units.get(0));
        //Parse la answer shuffle
        q.setAnswerShuffle(parseAnswerShuffle(questionXML));
    }

}
