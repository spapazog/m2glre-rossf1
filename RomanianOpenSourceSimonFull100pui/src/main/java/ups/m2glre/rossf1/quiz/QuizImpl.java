package ups.m2glre.rossf1.quiz;

import java.util.ArrayList;
import java.util.List;

import universite.toulouse.moodlexmlapi.core.data.Question;
import universite.toulouse.moodlexmlapi.core.data.Quiz;

/**
 * QuizzImplementation
 */
public class QuizImpl implements Quiz {

    private ArrayList<Question> listQuestion;

    /**
     * Création d'un objet QuizImpl
     */
    public QuizImpl() {
        listQuestion = new ArrayList<Question>();
    }

    /**
     * Ajoute la question à la liste
     */
    public void addQuestion(Question q) {
        listQuestion.add(q);
    }

     /**
     * @see universite.toulouse.moodlexmlapi.core.data.Quiz#getQuestionList()
     * @return la liste de question du quizz
     */
    public final List<Question> getQuestionList() {
        return listQuestion;
    }
}
