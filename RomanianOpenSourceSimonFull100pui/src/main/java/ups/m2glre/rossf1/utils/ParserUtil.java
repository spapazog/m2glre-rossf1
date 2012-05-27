package ups.m2glre.rossf1.utils;

import org.jdom.Attribute;
import org.jdom.Element;

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
}
