package ir.nasim;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.uZ2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC22035uZ2 {
    private static final Pattern a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static Map a(URI uri, String str) {
        Map mapEmptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            mapEmptyMap = new HashMap();
            Cv8 cv8C = Cv8.c(AbstractC9994at8.b('='));
            Iterator it = Cv8.c(AbstractC9994at8.b('&')).b().d(rawQuery).iterator();
            while (it.hasNext()) {
                List listF = cv8C.f((String) it.next());
                if (listF.isEmpty() || listF.size() > 2) {
                    throw new IllegalArgumentException("bad parameter");
                }
                mapEmptyMap.put(b((String) listF.get(0), str), listF.size() == 2 ? b((String) listF.get(1), str) : null);
            }
        }
        return mapEmptyMap;
    }

    private static String b(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
