package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.DescriptionQuestion;

public class DescriptionQuestionParser extends QuestionParser {

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
