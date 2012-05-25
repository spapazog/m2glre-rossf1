package ups.m2glre.rossf1.quiz;

import java.util.List;

import universite.toulouse.moodlexmlapi.core.data.ImportedQuiz;
import universite.toulouse.moodlexmlapi.core.data.Question;
import universite.toulouse.moodlexmlapi.core.data.Quiz;

public class ImportedQuizImpl implements ImportedQuiz {
    private Quiz quiz;

    public ImportedQuizImpl(Quiz q) {
        quiz = q;
    }

    public List<Question> getQuestionList() {
        return quiz.getQuestionList();
    }

    public int getProcessedQuestionCount() {
        //A REVOIR !
        return quiz.getQuestionList().size();
    }

    public int getExtractedQuestionCount() {
        //A REVOIR !
        return quiz.getQuestionList().size();
    }

    public int getNonExtractedQuestionCount() {
        //A REVOIR !
        return 0;
    }

    public List<Question> getProcessedQuestionList() {
        //A REVOIR !
        return quiz.getQuestionList();
    }

    public List<Question> getExtractedQuestionList() {
        //A REVOIR !
        return quiz.getQuestionList();
    }

    public List<Question> getNonExtractedQuestionList() {
        //A REVOIR !
        return quiz.getQuestionList();
    }

}
