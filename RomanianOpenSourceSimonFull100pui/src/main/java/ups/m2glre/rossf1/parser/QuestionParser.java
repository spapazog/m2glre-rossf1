package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.GenericQuestion;

/**
 * QuestionParser.
 * @author steeepph
 *
 */
public abstract class QuestionParser {
    /**
     * Représentation d'une question
     */
    private GenericQuestion question;

    /**
     * @param questionXML issue du XML
     * @return la question parsée
     */
    public final Question parseQuestion(final Element questionXML) {
        question = new GenericQuestion();
        parseGenericField(questionXML);
        parseSpecializedQuestion(questionXML);

        return question;
    }

    /**
     * Méthode de parsage d'une question spéciale à implémenter
     * @param questionXML issue du XML
     */
    public abstract void parseSpecializedQuestion(Element questionXML);

    /**
     * Méthode de parsage des champs génériques
     * @param questionXML issue du XML
     */
    public final void parseGenericField(final Element questionXML) {
        question.setName("Test");
    }
}
