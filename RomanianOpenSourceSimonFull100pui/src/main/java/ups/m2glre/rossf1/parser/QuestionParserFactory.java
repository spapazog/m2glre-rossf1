package ups.m2glre.rossf1.parser;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;

public class QuestionParserFactory {
    public static QuestionParser getQuestionParser(String questionCategory)
        throws Exception {

        QuestionType questionType = QuestionType.valueOf(questionCategory);  
        switch (questionType) {
        case matching: return new MatchingQuestionParser();
            //case numerical : return new NumericalQuestionParser();
            /*todo: implement the other types when created
            description,
            essay,
            calculated,
            cloze,
            multichoice,
            shortanswer,
            truefalse,
            category*/
        }
        throw new Exception("Not implemented question type");
    }

}
