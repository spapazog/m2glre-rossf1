package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.CategoryQuestion;

public class CategoryQuestionParser extends QuestionParser {

    public void parseSpecializedQuestion(Element questionXML)
            throws InvalidQuizFormatException {
        CategoryQuestion q = (CategoryQuestion) question;

        q.setCategoryText(questionXML.
                getChild("category").getChild("text").getValue());
    }
}
