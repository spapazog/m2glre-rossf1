package ups.m2glre.rossf1.quiz;

import java.io.InputStream;
import java.io.OutputStream;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import universite.toulouse.moodlexmlapi.core.InvalidStreamSizeException;
import universite.toulouse.moodlexmlapi.core.QuizImportExportService;
import universite.toulouse.moodlexmlapi.core.data.ImportedQuiz;
import universite.toulouse.moodlexmlapi.core.data.Quiz;

/**
 * Service d'import/export de Quizz moodle
 * @author steeepph
 *
 */
public class QuizServiceImpl implements QuizImportExportService {

    /**
     * Importation d'un quizz
     * @param is : fichier XML
     * @throws InvalidQuizFormatException si le quiz n'est pas de la bonne forme
     * @throws InvalidStreamSizeException si la taille du quizz depasse les
     * bornes
     * @return un Quiz
     */
    public final ImportedQuiz importQuiz(final InputStream is)
            throws InvalidQuizFormatException, InvalidStreamSizeException {
        /**
         * Faire un QuizParser
         * Récupérer le quizz
         * Le transformer en ImportedQuiz
         */
        return null;
    }

    /**
     * Exportation d'un quizz
     * @param quiz : objet Quizz à exporter
     * @return une reference vers un fichier XML
     */
    public final OutputStream exportQuiz(final Quiz quiz) {
        return null;
    }

}
