package ups.m2glre.rossf1.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** Calculated question model
 */
public class CalculatedQuestion extends GenericQuestion {

	int answerFraction;
	String answerTxt;
	float answerTolerance;
	int answerToleranceType;
	int answerCorrectAnswerFormat;
	int answerCorrectAnswerLength;
	String answerFeedbackText;
	
	/*
	 * Units represents all the unit <unit> node
	 * key of the HashMap is the multiplier value, value is name
	 */
	HashMap<Integer, String> units = new HashMap<Integer, String>();

	List<DataSetDefinition> definitions = new ArrayList<DataSetDefinition>();

	public int getAnswerFraction() {
		return answerFraction;
	}

	public void setAnswerFraction(int answerFraction) {
		this.answerFraction = answerFraction;
	}
	
	public String getAnswerTxt() {
		return answerTxt;
	}

	public void setAnswerTxt(String answerTxt) {
		this.answerTxt = answerTxt;
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
	
	public HashMap<Integer, String> getUnits() {
		return units;
	}
	
	public void setUnits(HashMap<Integer, String> units) {
		this.units = units;
	}
	
	public void addUnit(int mult, String unitName) {
		units.put(mult, unitName);
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
