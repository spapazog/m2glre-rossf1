package ups.m2glre.rossf1.parser;

import java.util.Iterator;
import java.util.List;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.MatchingQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;

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

    private MatchingQuestion matchingQuestion;

    @Override
    public final void parseSpecializedQuestion(Element questionElement)
            throws InvalidQuizFormatException {

        matchingQuestion = (MatchingQuestion) question;

        // browse subquestions
        try {

            List listQuestions = questionElement.getChildren(MoodleXML.TAG_SUBQUESTION);
            Iterator i = listQuestions.iterator();

            while (i.hasNext()) {
                Element subQuestionXML = (Element) i.next();
                parseSubQuestion(subQuestionXML);
            }

            Element suffleElement = questionElement.getChild(MoodleXML.TAG_SUFFLE);
            if (suffleElement == null)
                throw new Throwable("Node doesn't contain"
                        + MoodleXML.TAG_SUFFLE + "element.");
            boolean suffleAnswer = Boolean.parseBoolean(suffleElement.getText());
            matchingQuestion.setSuffleAnswer(suffleAnswer);

        } catch (Throwable t) {
            throw new InvalidQuizFormatException(t);
        }
    }

    private void parseSubQuestion(Element subQuestionElement)
            throws Throwable {

        // get children element
        Element textElement = subQuestionElement.getChild(MoodleXML.TAG_TEXT);
        if (textElement == null)
            throw new Throwable(MoodleXML.TAG_SUBQUESTION +
                    " node doesn't contain" + MoodleXML.TAG_TEXT + "element.");

        Element answerElement = subQuestionElement.
                getChild(MoodleXML.TAG_SUBQUESTION_ANSWER);
        if (answerElement == null)
            throw new Throwable(MoodleXML.TAG_SUBQUESTION +
                    " node doesn't contain"+ MoodleXML.TAG_SUBQUESTION_ANSWER +
                    "element.");

        Element answerTextElement = answerElement.getChild(MoodleXML.TAG_TEXT);
        if (answerTextElement == null) {
            throw new Throwable(MoodleXML.TAG_SUBQUESTION +
                    " node doesn't contain"+ MoodleXML.TAG_TEXT +
                    "element.");
        }

        matchingQuestion.addSubquestion(textElement.getText(),
                answerTextElement.getText());
    }
}
