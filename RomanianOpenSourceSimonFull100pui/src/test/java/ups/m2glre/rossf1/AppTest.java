package ups.m2glre.rossf1;

import universite.toulouse.moodlexmlapi.core.data.QuestionError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public AppTest(final String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public final void testApp() {
        QuestionError questionError = new QuestionError("type not supported",
                "the question type is not supported");
        System.out.println(questionError.getDescription());
        assertEquals("type not supported", questionError.getCode());
    }
}
