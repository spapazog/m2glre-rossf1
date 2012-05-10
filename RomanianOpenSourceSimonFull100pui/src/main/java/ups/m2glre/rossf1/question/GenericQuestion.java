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

    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    public QuestionText getQuestionText() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getGeneralFeedBack() {
        // TODO Auto-generated method stub
        return null;
    }

    public Float getPenalty() {
        // TODO Auto-generated method stub
        return null;
    }

    public Float getDefaultGrade() {
        // TODO Auto-generated method stub
        return null;
    }

    public Boolean isHidden() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getImageUrl() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getImageBase64() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<QuestionError> getErrors() {
        // TODO Auto-generated method stub
        return null;
    }
}
