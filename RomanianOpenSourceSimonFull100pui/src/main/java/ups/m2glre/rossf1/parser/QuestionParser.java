package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.Question;

/**
 * QuestionParser.
 * @author steeepph
 *
 */
public abstract class QuestionParser {
    /**
     * @param question issue du XML
     * @return la question parsée
     */
    public abstract Question parseQuestion(Element question);
}
