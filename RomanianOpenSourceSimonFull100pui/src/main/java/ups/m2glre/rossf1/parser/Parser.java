package ups.m2glre.rossf1.parser;

import java.io.IOException;
import java.io.InputStream;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import universite.toulouse.moodlexmlapi.core.data.Quiz;

/**
 * Classe Parseur général
 * @author steeepph
 *
 */
public class Parser {
    private Document document;

    /**
     * Constructeur de la classe parseur
     * @param is fichier
     */
    public Parser(final InputStream is) {
       try {
           //Construction du document à partir de is
           document = new SAXBuilder().build(is);

           //Création du parseur
           new QuizParser();

       } catch (JDOMException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    /**
     * Parse le quiz
     */
    public Quiz parseQuiz() {
        return new QuizParser().parseQuiz(document.getRootElement());
    }
}
