package ups.m2glre.rossf1.utils;

import org.jdom.Attribute;
import org.jdom.Element;

/**
 * Classe des constantes des fichiers XML de Moodle
 * @author steeepph
 *
 */
public class MoodleXML {
	/* Common XML nodes */
    public static final String TAG_QUESTION = "question";
    public static final String TAG_QUIZ = "quiz";
    public static final String TAG_NAME = "name";
    public static final String TAG_TEXT = "text";
    public static final String TAG_ANSWER = "answer";
    public static final String TAG_FEEDBACK = "feedback";
    public static final String TAG_SUFFLE = "shuffleanswers";
    
    public static final String TAG_CATEGORY = "category";
    public static final String TAG_FRACTION = "fraction";
    public static final String TAG_TOLERANCE = "tolerance";
    public static final String TAG_UNITS = "units";
    public static final String TAG_UNIT = "unit";
    public static final String TAG_MULTIPLIER = "multiplier";
    public static final String TAG_UNIT_NAME = "unit_name";
    public static final String TAG_HIDDEN = "hidden";
    public static final String TAG_PENALTY = "penalty";
    public static final String TAG_GENERALFEEDBACK = "generalfeedback";
    public static final String TAG_DEFAULTGRADE = "defaultgrade";
    public static final String TAG_SHUFFLEANSWERS = "shuffleanswers";
    public static final String TAG_QUESTIONTEXT = "questiontext";
    public static final String TAG_FORMAT = "format";
    public static final String TAG_TYPE = "type";
    public static final String TAG_ANSWERNUMBERING = "answernumbering";
    public static final String TAG_INCORRECTFB = "incorrectfeedback";
    public static final String TAG_PARTCORRECTFB = "partiallycorrectfeedback";
    public static final String TAG_CORRECTFB = "correctfeedback";
    public static final String TAG_SINGLE = "single";
    
    /* Matching question specific */
    public static final String TAG_SUBQUESTION = "subquestion";
    public static final String TAG_SUBQUESTION_ANSWER = "answer";
    
    /* Calculated question specific */
    public static final String TAG_CORRECTANSWERFORMAT = "correctanswerformat";
    public static final String TAG_CORRECTANSWERLENGTH = "correctanswerlength";
	public static final String TAG_TOLERANCETYPE = "tolerancetype";
	public static final String TAG_DATASETDEFINITIONS = "dataset_definitions";
	public static final String TAG_DATASETDEFINITION = "dataset_definition";
	public static final String TAG_STATUS = "status";
	public static final String TAG_DISTRIBUTION = "distribution";
	public static final String TAG_MINIMUM = "minimum";
	public static final String TAG_MAXIMUM = "maximum";
	public static final String TAG_DECIMALS = "decimals";
	public static final String TAG_DATASETITEMS = "dataset_items";
	public static final String TAG_DATASETITEM = "dataset_item";
	public static final String TAG_NUMBER = "number";
	public static final String TAG_VALUE = "value";

    public static final String TAG_IMAGE64 = "image_base64";
    public static final String TAG_IMAGEURL = "image";

}
