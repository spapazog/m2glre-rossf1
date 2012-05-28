package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import ups.m2glre.rossf1.question.EssayQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;

/**
 * Essay Question Parser.
 *
 */
public class EssayQuestionParser extends QuestionParser {

    /**
     * Parser of the specialized nodes for EssayQuestion
     * @param questionElement node element of the question
     * @throws exception if the format of the XML is not valid
     */
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
