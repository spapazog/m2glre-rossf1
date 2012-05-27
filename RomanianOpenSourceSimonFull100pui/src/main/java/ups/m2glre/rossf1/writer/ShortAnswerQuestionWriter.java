package ups.m2glre.rossf1.writer;

import org.jdom.Attribute;
import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.ShortAnswerQuestion;
import ups.m2glre.rossf1.question.internal.Answer;
import ups.m2glre.rossf1.utils.MoodleXML;
import ups.m2glre.rossf1.utils.WriterUtil;

/**
 * @author steeepph
 *
 */
public class ShortAnswerQuestionWriter extends QuestionWriter {
    public void writeSpecializedQuestion(Question question) {
        ShortAnswerQuestion q = (ShortAnswerQuestion) question;

        //Answers shuffle
        writeAnswerShuffle(q.isAnswerShuffle());

        //Answers
        for (Answer a : q.getAnswers()) {
            Element answer = new Element(MoodleXML.TAG_ANSWER);
            answer.setAttribute(new Attribute(MoodleXML.TAG_FRACTION,
                    String.valueOf(a.getFraction())));
            Element answerText = new Element(MoodleXML.TAG_TEXT);
            answerText.setText(a.getText());
            answer.addContent(answerText);
            answer.addContent(WriterUtil.writeElementWithText(
                    MoodleXML.TAG_FEEDBACK, a.getFeedbackText()));
            questionXML.addContent(answer);
        }
    }
}
