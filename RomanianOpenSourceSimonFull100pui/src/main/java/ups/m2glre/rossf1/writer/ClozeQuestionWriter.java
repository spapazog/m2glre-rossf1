package ups.m2glre.rossf1.writer;

import universite.toulouse.moodlexmlapi.core.data.Question;
import ups.m2glre.rossf1.question.ClozeQuestion;

/**
 * @author steeepph
 *
 */
public class ClozeQuestionWriter extends QuestionWriter {
    public void writeSpecializedQuestion(Question question) {
        ClozeQuestion q = (ClozeQuestion) question;

        //Answers shuffle
        writeAnswerShuffle(q.isAnswerShuffle());
    }
}
