package j$.time;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class l implements Serializable {
    public static final Map a;

    static {
        HashMap map = new HashMap(64);
        map.put("ACT", "Australia/Darwin");
        map.put("AET", "Australia/Sydney");
        map.put("AGT", "America/Argentina/Buenos_Aires");
        map.put("ART", "Africa/Cairo");
        map.put("AST", "America/Anchorage");
        map.put("BET", "America/Sao_Paulo");
        map.put("BST", "Asia/Dhaka");
        map.put("CAT", "Africa/Harare");
        map.put("CNT", "America/St_Johns");
        map.put("CST", "America/Chicago");
        map.put("CTT", "Asia/Shanghai");
        map.put("EAT", "Africa/Addis_Ababa");
        map.put("ECT", "Europe/Paris");
        map.put("IET", "America/Indiana/Indianapolis");
        map.put("IST", "Asia/Kolkata");
        map.put("JST", "Asia/Tokyo");
        map.put("MIT", "Pacific/Apia");
        map.put("NET", "Asia/Yerevan");
        map.put("NST", "Pacific/Auckland");
        map.put("PLT", "Asia/Karachi");
        map.put("PNT", "America/Phoenix");
        map.put("PRT", "America/Puerto_Rico");
        map.put("PST", "America/Los_Angeles");
        map.put("SST", "Pacific/Guadalcanal");
        map.put("VST", "Asia/Ho_Chi_Minh");
        map.put("EST", "-05:00");
        map.put("MST", "-07:00");
        map.put("HST", "-10:00");
        a = Collections.unmodifiableMap(map);
    }

    l() {
        if (getClass() != ZoneOffset.class && getClass() != m.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static l h(String str, Map map) {
        int i;
        if (str == null) {
            throw new NullPointerException("zoneId");
        }
        if (map == null) {
            throw new NullPointerException("aliasMap");
        }
        String str2 = (String) map.get(str);
        if (str2 != null) {
            str = str2;
        }
        if (str.length() <= 1 || str.startsWith("+") || str.startsWith("-")) {
            return ZoneOffset.l(str);
        }
        if (str.startsWith("UTC") || str.startsWith("GMT")) {
            i = 3;
        } else {
            if (!str.startsWith("UT")) {
                return m.k(str, true);
            }
            i = 2;
        }
        return j(str, i, true);
    }

    public static l i(String str, ZoneOffset zoneOffset) {
        if (str == null) {
            throw new NullPointerException("prefix");
        }
        if (zoneOffset == null) {
            throw new NullPointerException("offset");
        }
        if (str.length() == 0) {
            return zoneOffset;
        }
        if (str.equals("GMT") || str.equals("UTC") || str.equals("UT")) {
            if (zoneOffset.k() != 0) {
                str = str.concat(zoneOffset.f());
            }
            return new m(str, j$.time.zone.c.e(zoneOffset));
        }
        throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: " + str);
    }

    private static l j(String str, int i, boolean z) {
        String strSubstring = str.substring(0, i);
        if (str.length() == i) {
            return i(strSubstring, ZoneOffset.UTC);
        }
        if (str.charAt(i) != '+' && str.charAt(i) != '-') {
            return m.k(str, z);
        }
        try {
            ZoneOffset zoneOffsetL = ZoneOffset.l(str.substring(i));
            return zoneOffsetL == ZoneOffset.UTC ? i(strSubstring, zoneOffsetL) : i(strSubstring, zoneOffsetL);
        } catch (c e) {
            throw new c("Invalid ID for offset-based ZoneId: " + str, e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            return f().equals(((l) obj).f());
        }
        return false;
    }

    public abstract String f();

    public abstract j$.time.zone.c g();

    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f();
    }
}
