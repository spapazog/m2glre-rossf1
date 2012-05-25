package ups.m2glre.rossf1.question;

public class ClozeQuestion extends GenericQuestion {

    private boolean answerShuffle;

    /**
     * @return the answerShuffle
     */
    public final boolean isAnswerShuffle() {
        return answerShuffle;
    }
    /**
     * @param answerShuffle the answerShuffle to set
     */
    public final void setAnswerShuffle(boolean answerShuffle) {
        this.answerShuffle = answerShuffle;
    }
}
