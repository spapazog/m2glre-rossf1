package ups.m2glre.rossf1.parser;

import java.util.Iterator;
import java.util.List;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.MultichoiceQuestion;
import ups.m2glre.rossf1.question.MultichoiceQuestion.MultichoiceAnswer;
import ups.m2glre.rossf1.utils.MoodleXML;

/**
 * @author Simon Joussellin
 */
public final class MultichoiceQuestionParser extends QuestionParser{

    @Override
    public void parseSpecializedQuestion(Element questionXML)
            throws InvalidQuizFormatException {

        MultichoiceQuestion quest = (MultichoiceQuestion) question;

            //Parse les answers
            List answers = questionXML.getChildren(MoodleXML.TAG_ANSWER);
            Iterator i = answers.iterator();

            while (i.hasNext()) {
                Float fraction;
                String answerText;
                String feedbackText;
                Element answer = (Element) i.next();

                fraction = Float.valueOf(answer.
                        getAttributeValue(MoodleXML.TAG_FRACTION));
                answerText = answer.getChild(MoodleXML.TAG_TEXT).getValue();
                feedbackText = answer.getChild(MoodleXML.TAG_FEEDBACK).
                        getChild(MoodleXML.TAG_TEXT).getValue();
                quest.getAnswers().add(quest.new MultichoiceAnswer(
                        fraction, answerText, feedbackText));
            }

            quest.setAnswerShuffle(parseAnswerShuffle(questionXML));

            //Parse le single
            quest.setSingle(questionXML.
                    getChild(MoodleXML.TAG_SINGLE).getValue() == "true");
            quest.setCorrectfeedbackText(questionXML.
                    getChild(MoodleXML.TAG_CORRECTFB).
                    getChild(MoodleXML.TAG_TEXT).getValue());
            quest.setPartiallyfeedbackText(questionXML.
                    getChild(MoodleXML.TAG_PARTCORRECTFB).
                    getChild(MoodleXML.TAG_TEXT).getValue());
            quest.setIncorrectfeedbackText(questionXML.
                    getChild(MoodleXML.TAG_INCORRECTFB).
                    getChild(MoodleXML.TAG_TEXT).getValue());
            quest.setAnswernumbering(questionXML.
                    getChild(MoodleXML.TAG_ANSWERNUMBERING).getValue());



    }

}
