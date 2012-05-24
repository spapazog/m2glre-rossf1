package ups.m2glre.rossf1.parser;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;

public class QuestionParserFactory {

    public static QuestionParser getQuestionParser(String questionCategory) throws Exception {
        
        QuestionType questionType = QuestionType.valueOf(questionCategory);  
        switch (questionType) {
            case numerical : return new NumericalQuestionParser();
            /*todo: implement the other types when created
            description,
            essay,
            calculated,
            matching,
            cloze,
            multichoice,
            shortanswer,
            truefalse,
            category*/
        }
        throw new Exception("Not implemented question type");
    }

}
