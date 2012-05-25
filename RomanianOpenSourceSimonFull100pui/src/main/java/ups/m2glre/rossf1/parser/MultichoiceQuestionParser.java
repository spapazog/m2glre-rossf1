package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.MultichoiceQuestion;
import ups.m2glre.rossf1.question.NumericalQuestion;

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
    		throws InvalidQuizFormatException{

    	MultichoiceQuestion quest = (MultichoiceQuestion) question;

    	try {
            //Parse la fraction de answer
            quest.setAnswerFraction(Integer.valueOf(
                    questionXML.getChild("answer").getAttributeValue("fraction")));
            //Parse le texte de answer
            quest.setAnswerText(questionXML.getChild("answer").
            		getChild("text").getValue());
            //Parse le answer shuffle
            quest.setAnswerShuffle(parseAnswerShuffle(questionXML));
            //Parse le texte de feedback de answer
            quest.setFeedbackText(questionXML.getChild("answer").getChild("feedback").
                    getChild("text").getValue());
            //Parse le single
            quest.setSingle(Integer.valueOf(questionXML.getChild("single")
                    .getValue()) == 1);
            quest.setCorrectfeedbackText(questionXML.getChild("correctfeedback").
                    getChild("text").getValue());
            quest.setPartiallyfeedbackText(questionXML.getChild("partiallycorrectfeedback").
                    getChild("text").getValue());
            quest.setIncorrectfeedbackText(questionXML.getChild("incorrectfeedback").
                    getChild("text").getValue());
            quest.setGeneralfeedbackText(questionXML.getChild("generalfeedback").
                    getChild("text").getValue());
            quest.setAnswernumbering(questionXML.getChild("answernumbering").getValue());

        } catch (Exception e) {
            throw new InvalidQuizFormatException(e.getCause());
        }

    }

}
