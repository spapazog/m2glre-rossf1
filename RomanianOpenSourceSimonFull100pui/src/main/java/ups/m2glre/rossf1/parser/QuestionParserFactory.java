package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import ups.m2glre.rossf1.utils.MoodleXML;

public class QuestionParserFactory {
    public static QuestionParser getQuestionParser(Element questionXML)
        throws Exception {

        switch (getQuestionType(questionXML)) {
            case matching: return new MatchingQuestionParser();
            case numerical: return new NumericalQuestionParser();
            case description: return new DescriptionQuestionParser();
            case cloze: return new ClozeQuestionParser();
            case category: return new CategoryQuestionParser();
            case essay: return new EssayQuestionParser();
            case multichoice: return new MultichoiceQuestionParser();
            //case calculated: return new NumericalQuestionParser();
            //case shortanswer: return new NumericalQuestionParser();
            //case truefalse: return new NumericalQuestionParser();
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
