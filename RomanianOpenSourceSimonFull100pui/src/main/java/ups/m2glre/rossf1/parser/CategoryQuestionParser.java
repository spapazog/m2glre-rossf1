package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import ups.m2glre.rossf1.question.CategoryQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;
import ups.m2glre.rossf1.utils.ParserUtil;

public class CategoryQuestionParser extends QuestionParser {

    public void parseSpecializedQuestion(Element questionXML)
            throws Throwable {
        CategoryQuestion q = (CategoryQuestion) question;

        Element categoryElement = ParserUtil.getElement(questionXML, MoodleXML.TAG_CATEGORY);
        String categoryText = ParserUtil.getElementText(categoryElement, MoodleXML.TAG_TEXT);

        q.setCategoryText(categoryText);
    }
}
