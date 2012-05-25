package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.MatchingQuestion;

/** Matching question parser
 * XML representation is <subquestion>1..* :
 *        <subquestion>
 *          <text>JBOSS</text>
 *          <answer>
 *           <text>Redhat</text>
 *          </answer>
 *        </subquestion>
 */
public class MatchingQuestionParser extends QuestionParser  {

    private final String TAG_SUBQUESTION = "subquestion";
    private final String TAG_SUBQUESTION_TEXT = "text";
    private final String TAG_SUBQUESTION_ANSWER = "answer";
    private final String TAG_SUFFLE = "shuffleanswers";
    private MatchingQuestion matchingQuestion;

    @Override
    public final void parseSpecializedQuestion(Element questionElement)
            throws InvalidQuizFormatException {

        matchingQuestion = (MatchingQuestion) question;

        // browse subquestions
        try {
            Element subQuestion;
            while ((subQuestion = questionElement.getChild(TAG_SUBQUESTION)) != null)
                parseSubQuestion(subQuestion);

            Element suffleElement = questionElement.getChild(TAG_SUFFLE);
            if (suffleElement == null)
                throw new Throwable("Node doesn't contain"
                        + TAG_SUFFLE + "element.");
            boolean suffleAnswer = Boolean.parseBoolean(suffleElement.getText());
            matchingQuestion.setSuffleAnswer(suffleAnswer);

        } catch (Throwable t) {
            throw new InvalidQuizFormatException(t);
        }
    }

    private void parseSubQuestion(Element subQuestionElement)
            throws Throwable {

        // get children element
        Element textElement = subQuestionElement.getChild(TAG_SUBQUESTION_TEXT);
        if (textElement == null)
            throw new Throwable(TAG_SUBQUESTION + " node doesn't contain"
                   + TAG_SUBQUESTION_TEXT + "element.");

        Element answerElement = subQuestionElement.getChild(TAG_SUBQUESTION_ANSWER);
        if (answerElement == null)
            throw new Throwable(TAG_SUBQUESTION + " node doesn't contain"
                    + TAG_SUBQUESTION_ANSWER + "element.");

        matchingQuestion.addSubquestion(textElement.getText(),
                answerElement.getText());
    }

}
