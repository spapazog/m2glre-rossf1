package ups.m2glre.rossf1.writer;

import org.jdom.Attribute;
import org.jdom.Element;
import universite.toulouse.moodlexmlapi.core.data.Question;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import ups.m2glre.rossf1.utils.MoodleXML;

/**
 * QuestionWriter.
 * @author steeepph
 *
 */
public abstract class QuestionWriter {

    protected Element questionXML;

    /**
     * @param questionXML issue du XML
     * @return la question parsée
     * @throws Exception question non gérée
     */
    public final Element writeQuestion(final Question question)
            throws Exception {
        questionXML = new Element(MoodleXML.TAG_QUESTION);
        writeQuestionType(question);
        writeGenericField(question);
        writeSpecializedQuestion(question);
        return questionXML;
    }

    /**
     * Parse le type de la question
     * @param questionXML question a parser
     */
    private void writeQuestionType(final Question question) {
        questionXML.setAttribute(new Attribute(MoodleXML.TAG_TYPE,
                question.getQuestionType().toString()));
    }

    /**
     * Méthode de parsage des champs génériques
     * @param questionXML issue du XML
     */
    public final void writeGenericField(final Question question) {
        //Pour les "questions" de type catégorie
        if (question.getQuestionType() == QuestionType.category)
            return;     //Uniquement texte/categorie dedans

        //Ecriture du nom
        Element textName = new Element(MoodleXML.TAG_TEXT);
        textName.setText(question.getName());
        Element name = new Element(MoodleXML.TAG_NAME);
        name.addContent(textName);
        questionXML.addContent(name);

        //Ecriture du texte de la question
        Element textQuestion = new Element(MoodleXML.TAG_TEXT);
        textQuestion.setText(question.getQuestionText().getText());
        Element questionText = new Element(MoodleXML.TAG_QUESTIONTEXT);
        questionText.setAttribute(new Attribute(MoodleXML.TAG_FORMAT,
                question.getQuestionText().getQuestionTextFormat().toString()));
        questionText.addContent(textQuestion);
        questionXML.addContent(questionText);

        //Ecriture du general feedback
        Element textFeedback = new Element(MoodleXML.TAG_TEXT);
        textFeedback.setText(question.getGeneralFeedBack());
        Element generalFeedback = new Element(MoodleXML.TAG_GENERALFEEDBACK);
        generalFeedback.addContent(textFeedback);
        questionXML.addContent(generalFeedback);

        //Ecriture du hidden
        Element hidden = new Element(MoodleXML.TAG_HIDDEN);
        if (question.isHidden())
            hidden.setText("1");
        else
            hidden.setText("0");
        questionXML.addContent(hidden);

        //Ecriture du penalty
        Element penalty = new Element(MoodleXML.TAG_PENALTY);
        penalty.setText(String.valueOf(question.getPenalty()));
        questionXML.addContent(penalty);

      //Ecriture du grade
        Element grade = new Element(MoodleXML.TAG_DEFAULTGRADE);
        grade.setText(String.valueOf(question.getDefaultGrade()));
        questionXML.addContent(grade);

        //Ecriture de l'image
        Element imageUrl = new Element(MoodleXML.TAG_IMAGEURL);
        imageUrl.setText(question.getImageUrl());
        questionXML.addContent(imageUrl);

        //Ecriture de l'image 64
        Element image64 = new Element(MoodleXML.TAG_IMAGE64);
        image64.setText(question.getImageBase64());
        questionXML.addContent(image64);
    }
    /**
     * Méthode redondante dans plusieurs type de question mais pas générique
     * @param questionXML la question à parser
     * @return
     */
    public void writeAnswerShuffle(final boolean shuffle) {
        Element answerShuffle = new Element(MoodleXML.TAG_SHUFFLEANSWERS);
        if (shuffle)
            answerShuffle.setText("1");
        else
            answerShuffle.setText("0");
        questionXML.addContent(answerShuffle);
    }
    /**
     * Writer des elements des questions
     * @param question
     */
    public abstract void writeSpecializedQuestion(Question question);
}
