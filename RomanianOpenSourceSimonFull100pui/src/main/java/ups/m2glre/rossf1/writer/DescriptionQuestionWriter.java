package ups.m2glre.rossf1.writer;

import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.DescriptionQuestion;

/**
 * @author steeepph
 *
 */
public class DescriptionQuestionWriter extends QuestionWriter {
    public void writeSpecializedQuestion(Question question) {
        DescriptionQuestion q = (DescriptionQuestion) question;

        //Answers shuffle
        writeAnswerShuffle(q.isAnswerShuffle());
    }
}
