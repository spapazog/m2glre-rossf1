package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import ups.m2glre.rossf1.question.EssayQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;

public class EssayQuestionParser extends QuestionParser {

    public void parseSpecializedQuestion(Element questionXML)
            throws Throwable {
        EssayQuestion q = (EssayQuestion) question;

        //Parse la fraction
        q.setAnswerFraction(Integer.valueOf(
                questionXML.getChild(MoodleXML.TAG_ANSWER).
                getAttributeValue(MoodleXML.TAG_FRACTION)));
        //Parse la valeur
        q.setAnswerText(questionXML.getChild(MoodleXML.TAG_ANSWER).
                getChild(MoodleXML.TAG_FEEDBACK).
                getChild(MoodleXML.TAG_TEXT).getValue());
        //Parse la answer shuffle
        q.setAnswerShuffle(parseAnswerShuffle(questionXML));
    }
}
