package ups.m2glre.rossf1.parser;

import universite.toulouse.moodlexmlapi.core.data.Question;

/**
 * QuestionParser.
 * @author steeepph
 *
 */
public abstract class QuestionParser {
    /**
     * @return la question parsée
     */
    public abstract Question parseQuestion();
}
