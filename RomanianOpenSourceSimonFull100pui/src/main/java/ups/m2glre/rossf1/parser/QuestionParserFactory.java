package ups.m2glre.rossf1.parser;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;

public class QuestionParserFactory {
    public static QuestionParser getQuestionParser(String questionCategory)
        throws Exception {

        QuestionType questionType = QuestionType.valueOf(questionCategory);
        switch (questionType) {
            case matching: return new MatchingQuestionParser();
            //GABRIEL: case essay: return new EssayQuestionParser();
            case numerical: return new NumericalQuestionParser();
            //SIMON: case multichoice: return new NumericalQuestionParser();
            case description: return new NumericalQuestionParser();

            //case calculated: return new NumericalQuestionParser();
            //case cloze: return new NumericalQuestionParser();
            //case shortanswer: return new NumericalQuestionParser();
            //case truefalse: return new NumericalQuestionParser();
            //case category: return new NumericalQuestionParser();
        }
        throw new Exception("Not implemented question type");
    }

}
