package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.NumericalQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;

public class NumericalQuestionParser extends QuestionParser {

    public void parseSpecializedQuestion(Element questionXML)
            throws InvalidQuizFormatException {
        NumericalQuestion q = (NumericalQuestion) question;

        try {
            //Parse la fraction
            q.setAnswerFraction(Integer.valueOf(questionXML.
                    getChild(MoodleXML.TAG_ANSWER).
                    getAttributeValue(MoodleXML.TAG_FRACTION)));
            //Parse la valeur
            q.setAnswerValue(Integer.valueOf(questionXML.
                    getChild(MoodleXML.TAG_ANSWER).
                    getChild(MoodleXML.TAG_TEXT).getValue()));
            //Parse la tolerence
            q.setAnswerTolerence(Integer.valueOf(questionXML.
                    getChild(MoodleXML.TAG_ANSWER).
                    getChild(MoodleXML.TAG_TOLERANCE).getValue()));
            //Parse l'unité
            q.setAnswerUnitMultiplier(Integer.valueOf(questionXML.
                    getChild(MoodleXML.TAG_UNITS).
                    getChild(MoodleXML.TAG_UNIT).
                    getChild(MoodleXML.TAG_MULTIPLIER).getValue()));
            //Parse le texte de l'unité
            q.setAnswerUnitName(questionXML.getChild(MoodleXML.TAG_UNITS).
                    getChild(MoodleXML.TAG_UNIT).
                    getChild(MoodleXML.TAG_UNIT_NAME).getValue());
            //Parse la answer shuffle
            q.setAnswerShuffle(parseAnswerShuffle(questionXML));
          //Parse le feedback text
            q.setFeedbackText(questionXML.getChild(MoodleXML.TAG_ANSWER).
                    getChild(MoodleXML.TAG_FEEDBACK).
                    getChild(MoodleXML.TAG_TEXT).getValue());
        } catch (Exception e) {
            throw new InvalidQuizFormatException(e.getCause());
        }
    }

}
