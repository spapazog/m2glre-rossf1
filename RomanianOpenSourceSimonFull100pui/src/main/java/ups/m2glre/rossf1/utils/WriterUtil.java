package ups.m2glre.rossf1.utils;

import org.jdom.Element;

public class WriterUtil {
    public static Element writeElement(String name, String value) {
        Element e = new Element(name);
        e.setText(value);

        return e;
    }
    public static Element writeElementWithText(String name, String value) {
        Element e = new Element(name);
        Element eText = new Element(MoodleXML.TAG_TEXT);
        e.addContent(eText);

        return e;
    }
}
