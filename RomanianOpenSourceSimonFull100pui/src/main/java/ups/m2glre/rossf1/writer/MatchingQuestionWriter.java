package ups.m2glre.rossf1.writer;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.MatchingQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;

/**
 * @author steeepph
 *
 */
public class MatchingQuestionWriter extends QuestionWriter {
    public void writeSpecializedQuestion(Question question) {
        MatchingQuestion q = (MatchingQuestion) question;

        //Answers shuffle
        writeAnswerShuffle(q.isSuffleAnswer());

        //Subquestion
        for (String key : q.getSubquestion().keySet()) {
            Element subquestion = new Element(MoodleXML.TAG_SUBQUESTION);
            Element textSubquestion = new Element(MoodleXML.TAG_TEXT);
            textSubquestion.setText(key);
            Element subquestionAnswer = new Element(MoodleXML.TAG_ANSWER);
            Element subquestionAnswerText = new Element(MoodleXML.TAG_TEXT);
            subquestionAnswerText.setText(q.getSubquestion().get(key));
            subquestionAnswer.addContent(subquestionAnswerText);
            subquestion.addContent(textSubquestion);
            subquestion.addContent(subquestionAnswer);
            questionXML.addContent(subquestion);
        }
    }
}
