package ups.m2glre.rossf1.writer;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.CategoryQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;

/**
 * @author steeepph
 *
 */
public class CategoryQuestionWriter extends QuestionWriter {
    public void writeSpecializedQuestion(Question question) {
        CategoryQuestion q = (CategoryQuestion) question;

        //Category
        Element category = new Element(MoodleXML.TAG_CATEGORY);
        Element categoryText = new Element(MoodleXML.TAG_TEXT);
        categoryText.setText(q.getCategoryText());
        category.addContent(categoryText);
        questionXML.addContent(category);
    }
}
