package ups.m2glre.rossf1.question;

import java.util.List;

import universite.toulouse.moodlexmlapi.core.data.Question;
import universite.toulouse.moodlexmlapi.core.data.QuestionError;
import universite.toulouse.moodlexmlapi.core.data.QuestionText;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;

/**
 * @author steeepph
 */
public abstract class GenericQuestion implements Question  {

    /**
     * @return le type de la question
     */
    public abstract QuestionType getQuestionType();

    /**
     * @return le nom de la question
     */
    public abstract String getName();

    /**
     * @return le texte de la question
     */
    public abstract QuestionText getQuestionText();

    /**
     * @return le feedback de la question
     */
    public abstract String getGeneralFeedBack();

    /**
     * @return la pénalité de la question
     */
    public abstract Float getPenalty();

    /**
     * @return le grade de la question
     */
    public abstract Float getDefaultGrade();

    /**
     * @return si la question est cachée
     */
    public abstract Boolean isHidden();

    /**
     * @return l'URL de l'image de la question
     */
    public abstract String getImageUrl();

    /**
     * @return l'image de la question
     */
    public abstract String getImageBase64();

    /**
     * @return la liste des erreurs de la question
     */
    public abstract List<QuestionError> getErrors();
}
