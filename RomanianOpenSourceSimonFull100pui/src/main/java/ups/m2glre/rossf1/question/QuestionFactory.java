package ups.m2glre.rossf1.question;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import ups.m2glre.rossf1.utils.MoodleXML;

/**
 * Question model factory.
 * @author gabriel
 *
 */
public class QuestionFactory {

    /**
     * Getting the matched question instance based on the question type.
     * @param questionXML node element of the question
     * @return the Question instance
     * @throws Exception if the question type is not selected
     */
    public static GenericQuestion getQuestion(Element questionXML)
            throws Exception {
        switch (getQuestionType(questionXML)) {
            case matching: return new MatchingQuestion();
            case numerical: return new NumericalQuestion();
            case description: return new DescriptionQuestion();
            case cloze: return new ClozeQuestion();
            case category: return new CategoryQuestion();
            case essay: return new EssayQuestion();
            case multichoice: return new MultichoiceQuestion();
            case calculated: return new CalculatedQuestion();
            case shortanswer: return new ShortAnswerQuestion();
            case truefalse: return new TrueFalseQuestion();
        }
        throw new Exception("Not implemented question type");
    }
    /**
     * Récupère le type de la question
     * @param questionXML question a parser
     * @return le type de la question
     */
    private static QuestionType getQuestionType(final Element questionXML) {
        return QuestionType.valueOf(questionXML.
                getAttributeValue(MoodleXML.TAG_TYPE));
    }
}
