package ups.m2glre.rossf1.question;

import java.util.List;

import universite.toulouse.moodlexmlapi.core.data.Question;
import universite.toulouse.moodlexmlapi.core.data.QuestionError;
import universite.toulouse.moodlexmlapi.core.data.QuestionText;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;

/**
 * Generic Question Model
 * @author steeepph
 */
public abstract class GenericQuestion implements Question  {

    private String name;
    private QuestionText questionText;
    private boolean questionHidden;
    private String feedback;
    private Float penalty;
    private Float grade;
    private QuestionType questionType;
    private String imageUrl;
    private String imageBase64;

    /**
     * @param questionType the questionType to set
     */
    public final void setQuestionType(final QuestionType questionType) {
        this.questionType = questionType;
    }

    /**
     * @param name the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * @param questionText the questionText to set
     */
    public final void setQuestionText(final QuestionText questionText) {
        this.questionText = questionText;
    }

    /**
     * @param questionHidden the questionHidden to set
     */
    public final void setQuestionHidden(final boolean questionHidden) {
        this.questionHidden = questionHidden;
    }

    /**
     * @param feedback the feedback to set
     */
    public final void setFeedback(final String feedback) {
        this.feedback = feedback;
    }

    /**
     * @param penalty the penalty to set
     */
    public final void setPenalty(final Float penalty) {
        this.penalty = penalty;
    }

    /**
     * @param imageUrl the image url to set
     */
    public final void setImgUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @param imageUrl the image url to set
     */
    public final void setImg64(final String image64) {
        this.imageBase64 = image64;
    }

    /**
     * @param grade the grade to set
     */
    public final void setGrade(final Float grade) {
        this.grade = grade;
    }

    /**
     * @return le type de la question
     */
    public final QuestionType getQuestionType() {
        return questionType;
    }

    /**
     * @return le nom de la question
     */
    public final String getName() {
        return name;
    }

    /**
     * @return le texte de la question
     */
    public final QuestionText getQuestionText() {
        return questionText;
    }

    /**
     * @return le feedback de la question
     */
    public final String getGeneralFeedBack() {
        return feedback;
    }

    /**
     * @return la pénalité de la question
     */
    public final Float getPenalty() {
        return penalty;
    }

    /**
     * @return le grade de la question
     */
    public final Float getDefaultGrade() {
        return grade;
    }

    /**
     * @return si la question est cachée
     */
    public final Boolean isHidden() {
        return questionHidden;
    }

    /**
     * @return l'URL de l'image de la question
     */
    public final String getImageUrl() {
        return imageUrl;
    }

    /**
     * @return l'image de la question
     */
    public final String getImageBase64() {
        return imageBase64;
    }

    /**
     * @return la liste des erreurs de la question
     */
    public final List<QuestionError> getErrors() {
        return null;
    }
}
