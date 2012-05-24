package ups.m2glre.rossf1.question;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;

public class QuestionFactory {

    public static GenericQuestion getQuestion(QuestionType questionType) 
            throws Exception {
        switch (questionType) {
            //case numerical : return new ();
            //case multichoice : return new MultichoiceQuestion();
            /*todo: implement the other types when created
            description,
            essay,
            calculated,
            matching,
            cloze,
            shortanswer,
            truefalse,
            category*/
        }
        throw new Exception("Not implemented question type");
    }
}
