package ups.m2glre.rossf1.question;

import java.util.ArrayList;
import java.util.List;

import ups.m2glre.rossf1.question.internal.DataSetDefinition;
import ups.m2glre.rossf1.question.internal.Unit;

/** Calculated question model
 */
public class CalculatedQuestion extends GenericQuestion {

    int answerFraction;
    String answerText;
    float answerTolerance;
    int answerToleranceType;
    int answerCorrectAnswerFormat;
    int answerCorrectAnswerLength;
    String answerFeedbackText;
    boolean answerShuffle;
    /*
     * Units represents all the unit <unit> node
     * key of the HashMap is the multiplier value, value is name
     */
    List<Unit> units = new ArrayList<Unit>();
    List<DataSetDefinition> definitions = new ArrayList<DataSetDefinition>();

    public final boolean isAnswerShuffle() {
        return answerShuffle;
    }
    public final void setAnswerShuffle(boolean answerShuffle) {
        this.answerShuffle = answerShuffle;
    }
    public int getAnswerFraction() {
        return answerFraction;
    }

    public void setAnswerFraction(int answerFraction) {
        this.answerFraction = answerFraction;
    }

    public String getAnswerTxt() {
        return answerText;
    }

    public void setAnswerTxt(String answerTxt) {
        this.answerText = answerTxt;
    }

    public float getAnswerTolerance() {
        return answerTolerance;
    }

    public void setAnswerTolerance(float tolerance) {
        this.answerTolerance = tolerance;
    }

    public int getAnswerToleranceType() {
        return answerToleranceType;
    }

    public void setAnswerToleranceType(int toleranceType) {
        this.answerToleranceType = toleranceType;
    }

    public int getAnswerCorrectAnswerFormat() {
        return answerCorrectAnswerFormat;
    }

    public void setAnswerCorrectAnswerFormat(int correctAnswerFormat) {
        this.answerCorrectAnswerFormat = correctAnswerFormat;
    }

    public int getAnswerCorrectAnswerLength() {
        return answerCorrectAnswerLength;
    }

    public void setAnswerCorrectAnswerLength(int correctAnswerLength) {
        this.answerCorrectAnswerLength = correctAnswerLength;
    }

    public String getAnswerFeedbackText() {
        return answerFeedbackText;
    }

    public void setAnswerFeedbackText(String feedbackText) {
        this.answerFeedbackText = feedbackText;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public List<DataSetDefinition> getDefinitions() {
        return definitions;
    }

    public void addDefinition(DataSetDefinition dsd) {
        definitions.add(dsd);
    }

    public void setDefinitions(List<DataSetDefinition> definitions) {
        this.definitions = definitions;
    }
}
