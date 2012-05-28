package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import ups.m2glre.rossf1.utils.MoodleXML;
import ups.m2glre.rossf1.utils.ParserUtil;

/**
 * Question Parser factory.
 * @author Gabriel
 *
 */
public class QuestionParserFactory {
    /**
     * Getting the matched instance based on the question type
     * @param node element of the question
     * @return the QuestionParser instance
     * @throws exception if the format of the XML is not valid
     */
    public static QuestionParser getQuestionParser(Element questionXML)
        throws Exception {

        try {
            switch (getQuestionType(questionXML)) {
                case matching: return new MatchingQuestionParser();
                case numerical: return new NumericalQuestionParser();
                case description: return new DescriptionQuestionParser();
                case cloze: return new ClozeQuestionParser();
                case category: return new CategoryQuestionParser();
                case essay: return new EssayQuestionParser();
                case multichoice: return new MultichoiceQuestionParser();
                case calculated: return new CalculatedQuestionParser();
                case shortanswer: return new ShortAnswerQuestionParser();
                case truefalse: return new TrueFalseQuestionParser();
            }
        } catch (Throwable t) {
            throw new InvalidQuizFormatException(t);
        }
        //this never happens, but eclipse doesn't know it...
        return null;
    }

    /**
     * Récupère le type de la question
     * @param questionXML question a parser
     * @return le type de la question
     */
    private static QuestionType getQuestionType(final Element questionXML) throws Throwable {
        String questionType = ParserUtil.getAttribute(questionXML, MoodleXML.TAG_TYPE);
        QuestionType type = QuestionType.valueOf(questionType);
        if (type == null)
            throw new Throwable("Unknown question type : "+questionType);
        return type;
    }
}
