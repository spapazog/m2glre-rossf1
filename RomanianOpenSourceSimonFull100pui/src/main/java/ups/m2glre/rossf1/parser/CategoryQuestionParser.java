package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.CategoryQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;

public class CategoryQuestionParser extends QuestionParser {

    public void parseSpecializedQuestion(Element questionXML)
            throws InvalidQuizFormatException {
        CategoryQuestion q = (CategoryQuestion) question;

        q.setCategoryText(questionXML.getChild(MoodleXML.TAG_CATEGORY).
                getChild(MoodleXML.TAG_TEXT).getValue());
    }
}
