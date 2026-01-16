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
        if (getClass() != m.class && getClass() != n.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static l v(String str, Map map) {
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
            return m.z(str);
        }
        if (str.startsWith("UTC") || str.startsWith("GMT")) {
            i = 3;
        } else {
            if (!str.startsWith("UT")) {
                return n.y(str, true);
            }
            i = 2;
        }
        return x(str, i, true);
    }

    public static l w(String str, m mVar) {
        if (str == null) {
            throw new NullPointerException("prefix");
        }
        if (mVar == null) {
            throw new NullPointerException("offset");
        }
        if (str.length() == 0) {
            return mVar;
        }
        if (str.equals("GMT") || str.equals("UTC") || str.equals("UT")) {
            if (mVar.y() != 0) {
                str = str.concat(mVar.g());
            }
            return new n(str, j$.time.zone.c.e(mVar));
        }
        throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: " + str);
    }

    private static l x(String str, int i, boolean z) {
        String strSubstring = str.substring(0, i);
        if (str.length() == i) {
            return w(strSubstring, m.d);
        }
        if (str.charAt(i) != '+' && str.charAt(i) != '-') {
            return n.y(str, z);
        }
        try {
            m mVarZ = m.z(str.substring(i));
            return mVarZ == m.d ? w(strSubstring, mVarZ) : w(strSubstring, mVarZ);
        } catch (c e) {
            throw new c("Invalid ID for offset-based ZoneId: " + str, e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            return g().equals(((l) obj).g());
        }
        return false;
    }

    public abstract String g();

    public int hashCode() {
        return g().hashCode();
    }

    public abstract j$.time.zone.c t();

    public String toString() {
        return g();
    }
}
