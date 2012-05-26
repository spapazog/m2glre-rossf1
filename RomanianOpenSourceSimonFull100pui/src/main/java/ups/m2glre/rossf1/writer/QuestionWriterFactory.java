package ups.m2glre.rossf1.writer;

import universite.toulouse.moodlexmlapi.core.data.Question;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;

public class QuestionWriterFactory {
    public static QuestionWriter getQuestionWriter(Question question)
        throws Exception {

        switch (getQuestionType(question)) {
            case matching: return new MatchingQuestionWriter();
            case numerical: return new NumericalQuestionWriter();
            case description: return new DescriptionQuestionWriter();
            case cloze: return new ClozeQuestionWriter();
            case category: return new CategoryQuestionWriter();
            case essay: return new EssayQuestionWriter();
            case multichoice: return new MultichoiceQuestionWriter();
            //case calculated: return new NumericalQuestionParser();
            //case shortanswer: return new NumericalQuestionParser();
            //case truefalse: return new NumericalQuestionParser();
        }
        throw new Exception("Not implemented question type");
    }

    /**
     * Récupère le type de la question
     * @param question question a parser
     * @return le type de la question
     */
    private static QuestionType getQuestionType(final Question question) {
        return question.getQuestionType();
    }
}
