package ups.m2glre.rossf1.parser;

import java.util.List;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.ShortAnswerQuestion;
import ups.m2glre.rossf1.question.internal.Answer;
import ups.m2glre.rossf1.utils.MoodleXML;
import ups.m2glre.rossf1.utils.ParserUtil;

/** ShortAnswer question parser
 * XML representation is  :
    <question type="shortanswer">
        <!-- generic nodes-->
        <shuffleanswers>0</shuffleanswers>
        <usecase>0</usecase>
        <answer fraction="100">
            <text></text>
            <feedback>
                <text></text>
            </feedback>
        </answer>
        <answer fraction="100">
            <text></text>
            <feedback>
                <text></text>
            </feedback>
        </answer>
    </question>
 */
public class ShortAnswerQuestionParser extends QuestionParser  {
    /**
     * ShortAnswerQuestion object representation.
     */
    private ShortAnswerQuestion shortAnswerQuestion;

    /**
     * Parser of the specialized nodes for ShortAnswerQuestion
     * @param questionElement node element of the question
     * @throws exception if the format of the XML is not valid
     */
    @Override
    public final void parseSpecializedQuestion(Element questionElement)
            throws InvalidQuizFormatException {

        shortAnswerQuestion = (ShortAnswerQuestion) question;
        boolean answerShuffle;
        int useCase;
        List<Answer> answers;

        try {
            answerShuffle = parseAnswerShuffle(questionElement);
            useCase = ParserUtil.getElementInt(questionElement, MoodleXML.TAG_USECASE);
            answers = ParserUtil.getAnswers(questionElement);
        } catch (Throwable t) {
            throw new InvalidQuizFormatException(t);
        }

        shortAnswerQuestion.setAnswerShuffle(answerShuffle);
        shortAnswerQuestion.setUseCase(useCase);
        shortAnswerQuestion.setAnswer(answers);
    }
}
