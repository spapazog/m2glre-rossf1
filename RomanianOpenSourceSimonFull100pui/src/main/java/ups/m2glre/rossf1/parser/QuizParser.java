package ups.m2glre.rossf1.parser;

import java.util.Iterator;
import java.util.List;

import org.jdom.Element;

/**
 * QuizParser.
 * @author steeepph
 *
 */
public class QuizParser {
    /**
     * Constructeur du Quiz
     * @param quizRoot node du quizz
     */
    public QuizParser(final Element quizRoot) {
        //Création de la liste de questions
        List listQuestions = quizRoot.getChildren("question");
        Iterator i = listQuestions.iterator();

        while (i.hasNext()) {
            Element questionXMLElement = (Element) i.next();

            String questionCategory = questionXMLElement.getAttributeValue("category");
            QuestionParser questionParser;
            try {
                questionParser = QuestionParserFactory.getQuestionParser(questionCategory);
                questionParser.parseQuestion(questionXMLElement);
            } catch (Exception e) {
                e.printStackTrace();
            }
         }
    }
}
