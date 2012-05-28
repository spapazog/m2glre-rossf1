package ups.m2glre.rossf1.parser;

import java.util.Iterator;
import java.util.List;

import org.jdom.Element;

import ups.m2glre.rossf1.question.MatchingQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;
import ups.m2glre.rossf1.utils.ParserUtil;

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

    /**
     * MachingQuestion object representation.
     */
    private MatchingQuestion matchingQuestion;

    /**
     * Parser of the specialized nodes for MatchingQuestion
     * @param questionElement node element of the question
     * @throws exception if the format of the XML is not valid
     */
    @Override
    public final void parseSpecializedQuestion(Element questionElement)
            throws Throwable {

        matchingQuestion = (MatchingQuestion) question;

        // browse subquestions
        parseSubQuestions(questionElement);

        Element shuffleElement = ParserUtil.getElement(questionElement, MoodleXML.TAG_SUFFLE);
        boolean shuffleAnswer = Boolean.parseBoolean(shuffleElement.getText());
        matchingQuestion.setSuffleAnswer(shuffleAnswer);
    }

    private void parseSubQuestions(Element questionElement)
            throws Throwable {

        // browse subquestions
        List listQuestions = questionElement.getChildren(MoodleXML.TAG_SUBQUESTION);
        Iterator i = listQuestions.iterator();

        while (i.hasNext()) {
            Element subQuestionElement = (Element) i.next();

            String textElement = ParserUtil.getElementText(subQuestionElement, MoodleXML.TAG_TEXT);
            Element answerElement = ParserUtil.getElement(subQuestionElement, MoodleXML.TAG_SUBQUESTION_ANSWER);
            String answerTextElement = ParserUtil.getElementText(answerElement, MoodleXML.TAG_TEXT);

            matchingQuestion.addSubquestion(textElement, answerTextElement);
        }
    }
}
