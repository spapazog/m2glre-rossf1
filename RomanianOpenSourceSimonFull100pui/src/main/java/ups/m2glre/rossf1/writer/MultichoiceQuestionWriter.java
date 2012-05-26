package ups.m2glre.rossf1.writer;

import org.jdom.Attribute;
import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.CategoryQuestion;
import ups.m2glre.rossf1.question.MultichoiceQuestion;
import ups.m2glre.rossf1.question.MultichoiceQuestion.MultichoiceAnswer;
import ups.m2glre.rossf1.utils.MoodleXML;

/**
 * @author steeepph
 *
 */
public class MultichoiceQuestionWriter extends QuestionWriter {
    public void writeSpecializedQuestion(Question question) {
        MultichoiceQuestion q = (MultichoiceQuestion) question;

        //Single
        Element single = new Element(MoodleXML.TAG_SINGLE);
        single.setText(String.valueOf(q.isSingle()));
        questionXML.addContent(single);

        //Shuffle
        writeAnswerShuffle(q.isAnswerShuffle());

        //Feedback correct
        Element correctFb = new Element(MoodleXML.TAG_CORRECTFB);
        Element correctFbText = new Element(MoodleXML.TAG_TEXT);
        correctFbText.setText(q.getCorrectfeedbackText());
        correctFb.addContent(correctFbText);
        questionXML.addContent(correctFb);

        //Feedback partially correct
        Element partiallyCorrectFb = new Element(MoodleXML.TAG_PARTCORRECTFB);
        Element partiallyCorrectFbText = new Element(MoodleXML.TAG_TEXT);
        partiallyCorrectFbText.setText(q.getPartiallyfeedbackText());
        partiallyCorrectFb.addContent(partiallyCorrectFbText);
        questionXML.addContent(partiallyCorrectFb);

        //Feedback incorrect
        Element incorrectFb = new Element(MoodleXML.TAG_INCORRECTFB);
        Element incorrectFbText = new Element(MoodleXML.TAG_TEXT);
        incorrectFbText.setText(q.getPartiallyfeedbackText());
        incorrectFb.addContent(incorrectFbText);
        questionXML.addContent(incorrectFb);

        //Answernumbering
        Element answerNumbering = new Element(MoodleXML.TAG_ANSWERNUMBERING);
        answerNumbering.setText(q.getAnswernumbering());
        questionXML.addContent(answerNumbering);

        //Answers
        for (MultichoiceAnswer a : q.getAnswers()) {
            Element answer = new Element(MoodleXML.TAG_ANSWER);
            answer.setAttribute(new Attribute(MoodleXML.TAG_FRACTION,
                    String.valueOf(a.getFraction())));
            Element answerText = new Element(MoodleXML.TAG_TEXT);
            answerText.setText(a.getText());
            answer.addContent(answerText);
            Element feedback = new Element(MoodleXML.TAG_FEEDBACK);
            Element feedbackText = new Element(MoodleXML.TAG_TEXT);
            feedback.addContent(feedbackText);
            answer.addContent(feedback);

            questionXML.addContent(answer);
        }
    }
}
