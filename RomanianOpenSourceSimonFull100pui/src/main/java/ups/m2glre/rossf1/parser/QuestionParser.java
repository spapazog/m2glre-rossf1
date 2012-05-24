package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.data.Question;
import universite.toulouse.moodlexmlapi.core.data.QuestionText;
import universite.toulouse.moodlexmlapi.core.data.QuestionTextFormat;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import ups.m2glre.rossf1.question.GenericQuestion;

/**
 * QuestionParser.
 * @author steeepph
 *
 */
public abstract class QuestionParser {
    /**
     * Représentation d'une question
     */
    private GenericQuestion question;

    /**
     * @param questionXML issue du XML
     * @return la question parsée
     */
    public final Question parseQuestion(final Element questionXML) {
        question = new GenericQuestion();
        parseQuestionType(questionXML);
        parseQuestionText(questionXML);
        parseGenericField(questionXML);
        parseSpecializedQuestion(questionXML);

        return question;
    }

    /**
     * Méthode de parsage d'une question spéciale à implémenter
     * @param questionXML issue du XML
     */
    public abstract void parseSpecializedQuestion(Element questionXML);

    /**
     * Méthode de parsage des champs génériques
     * @param questionXML issue du XML
     */
    public final void parseGenericField(final Element questionXML) {
        //Parsage du nom
        question.setName(
                questionXML.getChild("name").getChild("text").getValue());

        //Parasage de question caché
        question.setQuestionHidden(
                Integer.valueOf(questionXML
                        .getChild("hidden").getValue()) == 1);

        //Parasage de feedback
        question.setFeedback(questionXML.
                getChild("generalfeedback").getChild("text").getValue());

        //Parasage de pénalité
        question.setPenalty(
                Float.valueOf(questionXML.getChild("penalty").getValue()));

        //Parsage de grade
        question.setGrade(
                Float.valueOf(questionXML.getChild("defaultgrade").getValue()));
    }

    /**
     * Parse le type de la question
     * @param questionXML question a parser
     */
    private void parseQuestionType(final Element questionXML) {
        String questionType = questionXML.getAttributeValue("type");

        if (questionType.equals("category"))
            question.setQuestionType(QuestionType.category);
        else if (questionType.equals("calculated"))
            question.setQuestionType(QuestionType.calculated);
        else if (questionType.equals("cloze"))
            question.setQuestionType(QuestionType.cloze);
        else if (questionType.equals("description"))
            question.setQuestionType(QuestionType.description);
        else if (questionType.equals("essay"))
            question.setQuestionType(QuestionType.essay);
        else if (questionType.equals("matching"))
            question.setQuestionType(QuestionType.matching);
        else if (questionType.equals("multichoice"))
            question.setQuestionType(QuestionType.multichoice);
        else if (questionType.equals("numerical"))
            question.setQuestionType(QuestionType.numerical);
        else if (questionType.equals("shortanswer"))
            question.setQuestionType(QuestionType.shortanswer);
        else if (questionType.equals("truefalse"))
            question.setQuestionType(QuestionType.truefalse);
    }

    /**
     * Parse le type de la question
     * @param questionXML question a parser
     */
    private void parseQuestionText(final Element questionXML) {
        //Parsing du format de texte
        String questionTextFormat = questionXML.
                getChild("questiontext").getAttributeValue("format");
        QuestionTextFormat qtf;

        if (questionTextFormat.equals("html"))
            qtf = QuestionTextFormat.html;
        else if (questionTextFormat.equals("moodle_auto_format"))
            qtf = QuestionTextFormat.moodle_auto_format;
        else if (questionTextFormat.equals("markdown"))
            qtf = QuestionTextFormat.markdown;
        else
            qtf = QuestionTextFormat.plain_text;

        //Parsing du texte
        String questionText = questionXML.
                getChild("questiontext").
                getChild("text").getValue();

        //Affectation du texte de la question
        question.setQuestionText(new QuestionText(questionText, qtf));
    }
}
