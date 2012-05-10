package ups.m2glre.rossf1.question;

import java.util.List;

import universite.toulouse.moodlexmlapi.core.data.QuestionError;
import universite.toulouse.moodlexmlapi.core.data.QuestionText;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;

/**
 * @author steeepph
 */
public class NumericalQuestion extends GenericQuestion  {

    /**
     * @return le type de la question
     */
    public final QuestionType getQuestionType() {
        return QuestionType.numerical;
    }

    /**
     * @return le nom de la question
     */
    public final String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return le texte de la question
     */
    public final QuestionText getQuestionText() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return le feedback de la question
     */
    public final String getGeneralFeedBack() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return la pénalité de la question
     */
    public final Float getPenalty() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return le grade de la question
     */
    public final Float getDefaultGrade() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return si la question est caché
     */
    public final Boolean isHidden() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return l'URL de l'image de la question
     */
    public final String getImageUrl() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return l'image de la question
     */
    public final String getImageBase64() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return la liste d'erreur de la question
     */
    public final List<QuestionError> getErrors() {
        // TODO Auto-generated method stub
        return null;
    }
}
