package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import ups.m2glre.rossf1.question.NumericalQuestion;

public class NumericalQuestionParser extends QuestionParser {

    public void parseSpecializedQuestion(Element questionXML)
            throws InvalidQuizFormatException {
        NumericalQuestion q = (NumericalQuestion) question;

        try {
            //Parse la fraction
            q.setAnswerFraction(Integer.valueOf(
                    questionXML.getChild("answer").getAttributeValue("fraction")));
            //Parse la valeur
            q.setAnswerValue(Integer.valueOf(
                    questionXML.getChild("answer").getChild("text").getValue()));
            //Parse la tolerence
            q.setAnswerTolerence(Integer.valueOf(
                    questionXML.getChild("answer").getChild("tolerance").getValue()));
            //Parse l'unité
            q.setAnswerUnitMultiplier(Integer.valueOf(
                    questionXML.getChild("units").getChild("unit").
                    getChild("multiplier").getValue()));
            //Parse le texte de l'unité
            q.setAnswerUnitName(questionXML.getChild("units").getChild("unit").
                    getChild("unit_name").getValue());
            //Parse la answer shuffle
            q.setAnswerShuffle(parseAnswerShuffle(questionXML));
          //Parse le feedback text
            q.setFeedbackText(questionXML.getChild("answer").getChild("feedback").
                    getChild("text").getValue());
        } catch (Exception e) {
            throw new InvalidQuizFormatException(e.getCause());
        }
    }

}
