package android.gov.nist.javax.sip.header;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class SIPHeaderNamesCache {
    private static final Map lowercaseMap = new ConcurrentHashMap();

    static {
        for (Field field : SIPHeaderNames.class.getFields()) {
            if (field.getType().equals(String.class) && Modifier.isStatic(field.getModifiers())) {
                try {
                    String str = (String) field.get(null);
                    String lowerCase = str.toLowerCase();
                    Map map = lowercaseMap;
                    map.put(str, lowerCase);
                    map.put(lowerCase, lowerCase);
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public static String toLowerCase(String str) {
        Map map = lowercaseMap;
        String str2 = (String) map.get(str);
        if (str2 != null) {
            return str2;
        }
        String strIntern = str.toLowerCase().intern();
        map.put(str, strIntern);
        map.put(strIntern, strIntern);
        return strIntern;
    }
}
