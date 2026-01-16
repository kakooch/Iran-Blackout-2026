package android.gov.nist.javax.sdp.parser;

import android.gov.nist.core.InternalErrorHandler;
import java.text.ParseException;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class ParserFactory {
    private static Class[] constructorArgs = {String.class};
    private static final String packageName = "android.gov.nist.javax.sdp.parser";
    private static Hashtable parserTable;

    static {
        Hashtable hashtable = new Hashtable();
        parserTable = hashtable;
        hashtable.put("a", getParser("AttributeFieldParser"));
        parserTable.put("b", getParser("BandwidthFieldParser"));
        parserTable.put("c", getParser("ConnectionFieldParser"));
        parserTable.put("e", getParser("EmailFieldParser"));
        parserTable.put("i", getParser("InformationFieldParser"));
        parserTable.put("k", getParser("KeyFieldParser"));
        parserTable.put("m", getParser("MediaFieldParser"));
        parserTable.put("o", getParser("OriginFieldParser"));
        parserTable.put("p", getParser("PhoneFieldParser"));
        parserTable.put("v", getParser("ProtoVersionFieldParser"));
        parserTable.put("r", getParser("RepeatFieldParser"));
        parserTable.put("s", getParser("SessionNameFieldParser"));
        parserTable.put("t", getParser("TimeFieldParser"));
        parserTable.put("u", getParser("URIFieldParser"));
        parserTable.put("z", getParser("ZoneFieldParser"));
    }

    public static SDPParser createParser(String str) throws ParseException {
        String fieldName = Lexer.getFieldName(str);
        if (fieldName == null) {
            return null;
        }
        Class cls = (Class) parserTable.get(fieldName.toLowerCase());
        if (cls != null) {
            try {
                return (SDPParser) cls.getConstructor(constructorArgs).newInstance(str);
            } catch (Exception e) {
                InternalErrorHandler.handleException(e);
                return null;
            }
        }
        throw new ParseException("Could not find parser for " + fieldName, 0);
    }

    private static Class getParser(String str) {
        try {
            return Class.forName("android.gov.nist.javax.sdp.parser." + str);
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find class");
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }
}
