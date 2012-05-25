package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.MultichoiceQuestion;
import ups.m2glre.rossf1.question.NumericalQuestion;
import ups.m2glre.rossf1.utils.MoodleXML;

/**
 *
 * @author Simon Joussellin
 *
 *<answer fraction="100">
<text>Ceci est la bonne réponse<text>
<feedback>
<text>Bravo !</text>
</feedback>
</answer>
<shuffleanswers>1</shuffleanswers>
<single>true</single>
<correctfeedback>
            <text></text>
        </correctfeedback>
        <partiallycorrectfeedback>
            <text></text>
        </partiallycorrectfeedback>
        <incorrectfeedback>
            <text></text>
        </incorrectfeedback>
        <answernumbering>none</answernumbering>
        <generalfeedback>
            <text></text>
        </generalfeedback>
 */
public final class MultichoiceQuestionParser extends QuestionParser{

    @Override
    public void parseSpecializedQuestion(Element questionXML)
            throws InvalidQuizFormatException {

        MultichoiceQuestion quest = (MultichoiceQuestion) question;

    	try {
            //Parse la fraction de answer
            quest.setAnswerFraction(Integer.valueOf(questionXML.
                    getChild(MoodleXML.TAG_ANSWER).
                    getAttributeValue(MoodleXML.TAG_FRACTION)));
            //Parse le texte de answer
            quest.setAnswerText(questionXML.
                    getChild(MoodleXML.TAG_ANSWER).
            		getChild(MoodleXML.TAG_TEXT).getValue());
            //Parse le answer shuffle
            quest.setAnswerShuffle(parseAnswerShuffle(questionXML));
            //Parse le texte de feedback de answer
            quest.setFeedbackText(questionXML.
                    getChild(MoodleXML.TAG_ANSWER).
                    getChild(MoodleXML.TAG_FEEDBACK).
                    getChild(MoodleXML.TAG_TEXT).getValue());
            //Parse le single
            quest.setSingle(Integer.valueOf(questionXML.
                    getChild(MoodleXML.TAG_SINGLE).getValue()) == 1);
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

        } catch (Exception e) {
            throw new InvalidQuizFormatException(e.getCause());
        }

    }

}
