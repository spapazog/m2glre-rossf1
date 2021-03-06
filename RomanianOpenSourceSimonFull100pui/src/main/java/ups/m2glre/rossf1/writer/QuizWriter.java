package ups.m2glre.rossf1.writer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import universite.toulouse.moodlexmlapi.core.data.Question;
import universite.toulouse.moodlexmlapi.core.data.Quiz;

public class QuizWriter {

    static Element quizRacine;
    static Document document;

    public QuizWriter(Quiz quiz) {
        quizRacine = new Element("quiz");
        document = new Document(quizRacine);
        QuestionWriter questionWriter;

        for (Question q : quiz.getQuestionList()) {
            try {
                questionWriter = QuestionWriterFactory.getQuestionWriter(q);
                quizRacine.addContent(questionWriter.writeQuestion(q));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public OutputStream getOutputStream() {
        try {
            OutputStream os = new FileOutputStream("target/export.xml");
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(document, os);
            return os;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
