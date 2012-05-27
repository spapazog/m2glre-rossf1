package ups.m2glre.rossf1.parser;

import java.util.List;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.TrueFalseQuestion;
import ups.m2glre.rossf1.question.internal.Answer;
import ups.m2glre.rossf1.utils.ParserUtil;

/** TrueFalse question parser
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
public class TrueFalseQuestionParser extends QuestionParser  {

    private TrueFalseQuestion trueFalseQuestion;

    @Override
    public final void parseSpecializedQuestion(Element questionElement)
            throws InvalidQuizFormatException {

        trueFalseQuestion = (TrueFalseQuestion) question;
        boolean answerShuffle;
        List<Answer> answers;

        try {
            answerShuffle = parseAnswerShuffle(questionElement);
            answers = ParserUtil.getAnswers(questionElement);
            if (answers.size() != 2)
                throw new Throwable("TrueFalse question should have 2 answers");

        } catch (Throwable t) {
            throw new InvalidQuizFormatException(t);
        }

        trueFalseQuestion.setAnswerShuffle(answerShuffle);
        trueFalseQuestion.setAnswer(answers);
    }
}
