package ups.m2glre.rossf1.parser;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;

public class QuestionParserFactory {
    public static QuestionParser getQuestionParser(String questionCategory)
        throws Exception {

        QuestionType questionType = QuestionType.valueOf(questionCategory);
        switch (questionType) {
            case matching: return new MatchingQuestionParser();
            case numerical: return new NumericalQuestionParser();
            case description: return new DescriptionQuestionParser();
            case cloze: return new ClozeQuestionParser();
            case category: return new CategoryQuestionParser();
            case multichoice: return new NumericalQuestionParser();
            //GABRIEL: case essay: return new EssayQuestionParser();
            //case calculated: return new NumericalQuestionParser();
            //case shortanswer: return new NumericalQuestionParser();
            //case truefalse: return new NumericalQuestionParser();
        }
        throw new Exception("Not implemented question type");
    }

}
