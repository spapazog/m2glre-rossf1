package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.ClozeQuestion;

/**
 * Cloze Question Parser.
 *
 */
public class ClozeQuestionParser extends DescriptionQuestionParser {

    /**
     * Parser of the specialized nodes for ClozeQuestion.
     * @param questionElement node element of the question
     * @throws exception if the format of the XML is not valid
     */
    public void parseSpecializedQuestion(Element questionXML)
            throws InvalidQuizFormatException {
        ClozeQuestion q = (ClozeQuestion) question;

        //Parse la answer shuffle
        q.setAnswerShuffle(parseAnswerShuffle(questionXML));
    }

}
