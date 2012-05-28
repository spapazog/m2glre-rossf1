package ups.m2glre.rossf1.writer;

import org.jdom.Attribute;
import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.EssayQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;

/**
 * @author steeepph
 *
 */
public class EssayQuestionWriter extends QuestionWriter {
    public void writeSpecializedQuestion(Question question) {
        EssayQuestion q = (EssayQuestion) question;
        //Answers shuffle
        writeAnswerShuffle(q.isAnswerShuffle());

        //Answer
        Element answer = new Element(MoodleXML.TAG_ANSWER);
        answer.setAttribute(new Attribute(MoodleXML.TAG_FRACTION,
                String.valueOf(q.getAnswerFraction())));
        Element feedback = new Element(MoodleXML.TAG_FEEDBACK);
        Element feedbackText = new Element(MoodleXML.TAG_TEXT);
        feedbackText.setText(q.getAnswerText());
        feedback.addContent(feedbackText);
        answer.addContent(feedback);
        questionXML.addContent(answer);
    }
}
