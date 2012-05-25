package ups.m2glre.rossf1.question;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;

public class QuestionFactory {

    public static GenericQuestion getQuestion(QuestionType questionType)
            throws Exception {
        switch (questionType) {
            case matching: return new MatchingQuestion();
            case numerical: return new NumericalQuestion();
            case description: return new DescriptionQuestion();
            case cloze: return new ClozeQuestion();
            case category: return new CategoryQuestion();
            case essay: return new EssayQuestion();
            case multichoice: return new NumericalQuestion();
            //case calculated: return new NumericalQuestion();
            //case shortanswer: return new NumericalQuestion();
            //ARNAUD: case truefalse: return new NumericalQuestion();
        }
        throw new Exception("Not implemented question type");
    }
}
