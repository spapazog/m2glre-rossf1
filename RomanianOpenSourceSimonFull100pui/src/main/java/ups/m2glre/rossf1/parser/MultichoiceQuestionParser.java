package ups.m2glre.rossf1.parser;

import java.util.List;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.MultichoiceQuestion;
import ups.m2glre.rossf1.question.internal.Answer;
import ups.m2glre.rossf1.utils.MoodleXML;
import ups.m2glre.rossf1.utils.ParserUtil;

/**
 * Multichoice Question Parser
 * @author Simon Joussellin
 */
public final class MultichoiceQuestionParser extends QuestionParser{

    /**
     * Parser of the specialized nodes for MultichoiceQuestion
     * @param questionElement node element of the question
     * @throws exception if the format of the XML is not valid
     */
    @Override
    public void parseSpecializedQuestion(Element questionXML)
            throws InvalidQuizFormatException {

        MultichoiceQuestion quest = (MultichoiceQuestion) question;

        List<Answer> answers;
        boolean answerShuffle;
        boolean single;
        String correctFeedbackText;
        String partiallyFeedbackText;
        String incorrectFeedbackText;
        String answerNumbering;

        try {
            //Parse les answers
            answers = ParserUtil.getAnswers(questionXML);
            answerShuffle = parseAnswerShuffle(questionXML);
            single = questionXML.
                   getChild(MoodleXML.TAG_SINGLE).getValue() == "true";
            correctFeedbackText = questionXML.
                    getChild(MoodleXML.TAG_CORRECTFB).
                    getChild(MoodleXML.TAG_TEXT).getValue();
            partiallyFeedbackText = questionXML.
                    getChild(MoodleXML.TAG_PARTCORRECTFB).
                    getChild(MoodleXML.TAG_TEXT).getValue();
            incorrectFeedbackText = questionXML.
                    getChild(MoodleXML.TAG_INCORRECTFB).
                    getChild(MoodleXML.TAG_TEXT).getValue();
            answerNumbering = questionXML.
                    getChild(MoodleXML.TAG_ANSWERNUMBERING).getValue();
        } catch (Throwable t) {
            throw new InvalidQuizFormatException(t);
        }

        quest.setAnswers(answers);
        quest.setAnswerShuffle(answerShuffle);
        quest.setSingle(single);
        quest.setCorrectfeedbackText(correctFeedbackText);
        quest.setPartiallyfeedbackText(partiallyFeedbackText);
        quest.setIncorrectfeedbackText(incorrectFeedbackText);
        quest.setAnswernumbering(answerNumbering);
    }
}
