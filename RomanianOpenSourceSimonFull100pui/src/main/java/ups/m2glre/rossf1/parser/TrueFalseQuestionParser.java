package ups.m2glre.rossf1.parser;

import java.util.List;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.TrueFalseQuestion;
import ups.m2glre.rossf1.question.internal.Answer;
import ups.m2glre.rossf1.utils.ParserUtil;

/**
 * TrueFalse Question Parser.
 *
 */
public class TrueFalseQuestionParser extends QuestionParser  {

    /**
     * Parser of the specialized nodes for TrueFalseQuestion
     * @param questionElement node element of the question
     * @throws exception if the format of the XML is not valid
     */
    @Override
    public final void parseSpecializedQuestion(Element questionElement)
            throws InvalidQuizFormatException {

        TrueFalseQuestion trueFalseQuestion = (TrueFalseQuestion) question;
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
