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
        OutputStream os = null;
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        try {
            //sortie.output(document, os);
            sortie.output(document, new FileOutputStream("yo.xml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return os;
    }

}
