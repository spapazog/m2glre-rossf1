package ups.m2glre.rossf1.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

import ups.m2glre.rossf1.question.internal.Answer;

public class ParserUtil {

    public static Element getElement(Element parent, String element) throws Throwable {
        Element e = parent.getChild(element);
        if (e == null)
            throw new Throwable("Node " + parent.getName() + " doesn't contains " + element + "node.");

        return e;
    }
    public static String getElementText(Element parent, String element) throws Throwable {
        return getElement(parent, element).getText();
    }
    public static float getElementFloat(Element parent, String element) throws Throwable {
        String s = getElementText(parent, element);

        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            throw new Throwable("Wrong type for node value " + element +
                    " expected float value");
        }
    }
    public static int getElementInt(Element parent, String element) throws Throwable {
        String s = getElementText(parent, element);

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new Throwable("Wrong type for node value " + element +
                    " expected int value");
        }
    }
    public static String getAttribute(Element element, String attributeName) throws Throwable {
        Attribute attribute = element.getAttribute(attributeName);
        if (attribute == null)
            throw new Throwable("Node " + element.getName() + " doesn't contains " + attributeName + "attribute.");

        return element.getAttributeValue(attributeName);
    }
    public static int getAttributeInt(Element element, String attributeName) throws Throwable {
        String res = getAttribute(element, attributeName);
        try {
            return Integer.parseInt(res);
        } catch (NumberFormatException e) {
            throw new Throwable("Wrong type for attribute " + attributeName + "in node" + element.getName()+
                    " expected integer value");
        }
    }
    public static float getAttributeFloat(Element element, String attributeName) throws Throwable {
        String res = getAttribute(element, attributeName);
        try {
            return Float.parseFloat(res);
        } catch (NumberFormatException e) {
            throw new Throwable("Wrong type for attribute " + attributeName + "in node" + element.getName()+
                    " expected float value");
        }
    }
    public static boolean getAttributeBoolean(Element element, String attributeName) throws Throwable {
        String res = getAttribute(element, attributeName);
        try {
            return Boolean.parseBoolean(res);
        } catch (NumberFormatException e) {
            // isn't "true" or "false", check for 0 and 1
            try {
                return Integer.parseInt(res) != 0;
            } catch (NumberFormatException e2) {
                throw new Throwable("Wrong type for attribute " + attributeName + "in node" + element.getName()+
                        " expected boolean value");
            }
        }
    }
    
    /*
     * getAnswers
     * @param parent, parent node of all answer node
     * @return List ofAnswer
     */
    public static List<Answer> getAnswers(Element parent) throws Throwable {
        List<Answer> answers = new ArrayList<Answer>();
        List answersElement = parent.getChildren(MoodleXML.TAG_ANSWER);
        Iterator i = answersElement.iterator();
        while (i.hasNext()) {
            Float fraction;
            String answerText;
            String feedbackText;
            Element answerElement = (Element) i.next();

            fraction = ParserUtil.getAttributeFloat(answerElement, MoodleXML.TAG_FRACTION);
            answerText = ParserUtil.getElementText(answerElement, MoodleXML.TAG_TEXT);
            feedbackText = answerElement.getChild(MoodleXML.TAG_FEEDBACK).
                    getChild(MoodleXML.TAG_TEXT).getValue();

            Answer answer = new Answer(fraction, answerText, feedbackText);
            answers.add(answer);
        }

        return answers;
    }
}
