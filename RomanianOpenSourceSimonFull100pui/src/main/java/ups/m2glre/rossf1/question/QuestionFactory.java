package ups.m2glre.rossf1.question;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import ups.m2glre.rossf1.parser.NumericalQuestionParser;
import ups.m2glre.rossf1.parser.QuestionParser;
import ups.m2glre.rossf1.parser.QuestionParserFactory;

public class QuestionFactory {

    public static GenericQuestion getQuestion(Element elementXML) throws Exception {
        
        String questionCategory = elementXML.getAttributeValue("category");
        
        QuestionType questionType = QuestionType.valueOf(questionCategory);  
        switch (questionType) {
            case numerical : return new NumericalQuestion();
            case multichoice : return new MultichoiceQuestion();
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
