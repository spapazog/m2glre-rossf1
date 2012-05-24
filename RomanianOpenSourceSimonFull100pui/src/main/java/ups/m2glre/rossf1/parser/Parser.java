package ups.m2glre.rossf1.parser;

import java.io.File;
import java.io.IOException;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * Classe Parseur général
 * @author steeepph
 *
 */
public class Parser {
    private org.jdom.Document document;
    private Element quizz;

    /**
     * Constructeur de la classe parseur
     * @param uri chemin du fichier
     * @throws JDOMException si erreur JDOM
     * @throws IOException si erreur IO
     */
    public Parser(final String uri) throws JDOMException, IOException {
       SAXBuilder sxb = new SAXBuilder();
       document = sxb.build(new File("Exercice2.xml"));
       
       new QuizParser(document.getRootElement());
    }
}
