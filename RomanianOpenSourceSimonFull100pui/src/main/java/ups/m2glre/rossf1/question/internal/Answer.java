package ups.m2glre.rossf1.question.internal;

public class Answer {

    private Float fraction;
    private String text;
    private String feedbackText;

    /**
     * @return the fraction
     */
    public final Float getFraction() {
        return fraction;
    }

    /**
     * @return the text
     */
    public final String getText() {
        return text;
    }

    /**
     * @return the feedbackText
     */
    public final String getFeedbackText() {
        return feedbackText;
    }

    public Answer(Float f, String t, String fe) {
        fraction = f;
        text = t;
        feedbackText = fe;
    }
}
