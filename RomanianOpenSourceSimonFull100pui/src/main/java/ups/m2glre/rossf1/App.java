package ups.m2glre.rossf1;

import universite.toulouse.moodlexmlapi.core.data.QuestionError;

/**
 * Hello world
 */
public final class App {
    /**
     * Methode main
     * @param args : argument du programme
     */
    public static void main(final String[] args) {
        System.out.println("Hello World!");
        QuestionError questionError = new QuestionError("type not supported",
                "the question type is not supported");
        System.out.println(questionError.getDescription()); 

        try {
        } catch (Exception e) {
        }
    }
}
