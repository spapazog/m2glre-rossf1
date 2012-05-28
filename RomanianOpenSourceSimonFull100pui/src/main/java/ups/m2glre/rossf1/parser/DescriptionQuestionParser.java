package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.DescriptionQuestion;

/**
 * Description Question Parser.
 *
 */
public class DescriptionQuestionParser extends QuestionParser {

    /**
     * Parser of the specialized nodes for DescriptionQuestion.
     * @param questionElement node element of the question
     * @throws exception if the format of the XML is not valid
     */
    public void parseSpecializedQuestion(Element questionXML)
            throws Throwable {
        DescriptionQuestion q = (DescriptionQuestion) question;

        try {
            //Parse la answer shuffle
            q.setAnswerShuffle(parseAnswerShuffle(questionXML));
        } catch (Exception e) {
            throw new InvalidQuizFormatException(e.getCause());
        }
    }
}
