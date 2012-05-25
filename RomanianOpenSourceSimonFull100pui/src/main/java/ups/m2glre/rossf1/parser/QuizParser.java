package ups.m2glre.rossf1.parser;

import java.util.Iterator;
import java.util.List;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.Question;
import universite.toulouse.moodlexmlapi.core.data.Quiz;
import ups.m2glre.rossf1.quiz.QuizImpl;
import ups.m2glre.rossf1.utils.MoodleXML;

/**
 * QuizParser.
 * @author steeepph
 *
 */
public class QuizParser {
    /**
     * Parseur de Quiz qui retourne un Quizz
     * @param quizRoot node du quizz
     * @return Quiz le quiz en java
     */
    public Quiz parseQuiz(final Element quizRoot) {
        //Création du quizz à retourner
        QuizImpl quiz = new QuizImpl();

        //Création de la liste de questions
        List listQuestions = quizRoot.getChildren(MoodleXML.TAG_QUESTION);
        Iterator i = listQuestions.iterator();

        while (i.hasNext()) {
            Element questionXML = (Element) i.next();
            QuestionParser questionParser;
            Question question;
            try {
                //Récupérer le QuestionParserFactory de la question
                questionParser = QuestionParserFactory.
                        getQuestionParser(questionXML);
                //Recupérer la question
                question = questionParser.parseQuestion(questionXML);
                //Ajouter la question au quizz
                quiz.addQuestion(question);
            } catch (Exception e) {
                e.printStackTrace();
            }
         }
        return quiz;
    }
}
