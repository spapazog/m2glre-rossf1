package ups.m2glre.rossf1.parser;

import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import universite.toulouse.moodlexmlapi.core.data.Question;
import universite.toulouse.moodlexmlapi.core.data.QuestionText;
import universite.toulouse.moodlexmlapi.core.data.QuestionTextFormat;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import ups.m2glre.rossf1.question.GenericQuestion;
import ups.m2glre.rossf1.question.QuestionFactory;
import ups.m2glre.rossf1.utils.MoodleXML;

/**
 * QuestionParser.
 * @author steeepph
 *
 */
public abstract class QuestionParser {
    /**
     * Représentation d'une question
     */
    protected GenericQuestion question;

    /**
     * @param questionXML issue du XML
     * @return la question parsée
     * @throws Exception question non gérée
     */
    public final Question parseQuestion(final Element questionXML)
            throws Exception {
        question = QuestionFactory.getQuestion(getQuestionType(questionXML));
        parseQuestionType(questionXML);
        parseQuestionText(questionXML);
        parseGenericField(questionXML);
        parseSpecializedQuestion(questionXML);

        return question;
    }

    /**
     * Méthode de parsage d'une question spéciale à implémenter
     * @param questionXML issue du XML
     * @throws InvalidQuizFormatException si le fichier n'est pas au bon format
     */
    public abstract void parseSpecializedQuestion(Element questionXML)
            throws InvalidQuizFormatException;

    /**
     * Méthode de parsage des champs génériques
     * @param questionXML issue du XML
     */
    public final void parseGenericField(final Element questionXML) {
        //Pour les "questions" de type catégorie
        if (question.getQuestionType() == QuestionType.category)
            return;     //Uniquement texte/categorie dedans

        //Parsage du nom
        question.setName(questionXML.
                getChild(MoodleXML.TAG_NAME).
                getChild(MoodleXML.TAG_TEXT).getValue());

        //Parasage de question caché
        if (questionXML.getChild(MoodleXML.TAG_HIDDEN) != null)
            question.setQuestionHidden(Integer.valueOf(questionXML
                        .getChild(MoodleXML.TAG_HIDDEN).getValue()) == 1);
        else
            question.setQuestionHidden(false);

        //Parasage de feedback
        question.setFeedback(questionXML.
                getChild(MoodleXML.TAG_GENERALFEEDBACK).
                getChild(MoodleXML.TAG_TEXT).getValue());

        //Parasage de pénalité
        if (questionXML.getChild(MoodleXML.TAG_PENALTY) != null)
            question.setPenalty(Float.valueOf(questionXML.
                    getChild(MoodleXML.TAG_PENALTY).getValue()));
        else
            question.setPenalty(0f);

        //Parsage de grade
        if (questionXML.getChild(MoodleXML.TAG_DEFAULTGRADE) != null)
            question.setGrade(Float.valueOf(questionXML.
                    getChild(MoodleXML.TAG_DEFAULTGRADE).getValue()));
        else
            question.setGrade(1f);
    }

    /**
     * Récupère le type de la question
     * @param questionXML question a parser
     * @return le type de la question
     */
    private QuestionType getQuestionType(final Element questionXML) {
        return QuestionType.valueOf(questionXML.getAttributeValue(MoodleXML.TAG_TYPE));
    }
    /**
     * Parse le type de la question
     * @param questionXML question a parser
     * @return le type de la question
     */
    private void parseQuestionType(final Element questionXML) {
        question.setQuestionType(QuestionType.valueOf(
                questionXML.getAttributeValue(MoodleXML.TAG_TYPE)));
    }

    /**
     * Parse le type de la question
     * @param questionXML question a parser
     */
    private void parseQuestionText(final Element questionXML) {
        //Pour les "questions" de type catégorie
        if (question.getQuestionType() == QuestionType.category)
            return;     //Uniquement texte/categorie dedans

        //Parsing du format de texte
        String questionTextFormat = questionXML.getChild(MoodleXML.TAG_QUESTIONTEXT).
                getAttributeValue(MoodleXML.TAG_FORMAT);
        //Dans le cas où le format n'est pas renseigné
        if (questionTextFormat == null)
            questionTextFormat = "moodle_auto_format";

        //Parsing du texte
        String questionText = questionXML.
                getChild(MoodleXML.TAG_QUESTIONTEXT).
                getChild(MoodleXML.TAG_TEXT).getValue();

        //Affectation du texte de la question
        question.setQuestionText(new QuestionText(questionText,
                QuestionTextFormat.valueOf(questionTextFormat)));
    }

    /**
     * Méthode redondante dans plusieurs type de question mais pas générique
     * @param questionXML la question à parser
     * @return
     */
    public boolean parseAnswerShuffle(final Element questionXML) {
        return Integer.valueOf(questionXML.getChild(MoodleXML.TAG_SHUFFLEANSWERS)
                .getValue()) == 1;
    }
}
