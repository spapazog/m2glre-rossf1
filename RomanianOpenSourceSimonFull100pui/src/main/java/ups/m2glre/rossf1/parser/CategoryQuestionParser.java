package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import ups.m2glre.rossf1.question.CategoryQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;
import ups.m2glre.rossf1.utils.ParserUtil;

/**
 * Category Question Parser.
 *
 */
public class CategoryQuestionParser extends QuestionParser {

    /**
     * Parser of the specialized nodes for CategoryQuestion.
     * @param questionElement node element of the question
     * @throws exception if the format of the XML is not valid
     */
    public void parseSpecializedQuestion(Element questionXML)
            throws Throwable {
        CategoryQuestion q = (CategoryQuestion) question;

        Element categoryElement = ParserUtil.getElement(questionXML, MoodleXML.TAG_CATEGORY);
        String categoryText = ParserUtil.getElementText(categoryElement, MoodleXML.TAG_TEXT);

        q.setCategoryText(categoryText);
    }
}
