package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class Xh8 {
    public static final Xh8 b = new Xh8(null, null);
    private final EnumMap a;

    public Xh8(Boolean bool, Boolean bool2) {
        EnumMap enumMap = new EnumMap(Qh8.class);
        this.a = enumMap;
        enumMap.put((EnumMap) Qh8.AD_STORAGE, (Qh8) bool);
        enumMap.put((EnumMap) Qh8.ANALYTICS_STORAGE, (Qh8) bool2);
    }

    public static Xh8 a(Bundle bundle) {
        if (bundle == null) {
            return b;
        }
        EnumMap enumMap = new EnumMap(Qh8.class);
        for (Qh8 qh8 : Qh8.values()) {
            enumMap.put((EnumMap) qh8, (Qh8) n(bundle.getString(qh8.a)));
        }
        return new Xh8(enumMap);
    }

    public static Xh8 b(String str) {
        EnumMap enumMap = new EnumMap(Qh8.class);
        if (str != null) {
            int i = 0;
            while (true) {
                Qh8[] qh8Arr = Qh8.d;
                int length = qh8Arr.length;
                if (i >= 2) {
                    break;
                }
                Qh8 qh8 = qh8Arr[i];
                int i2 = i + 2;
                if (i2 < str.length()) {
                    char cCharAt = str.charAt(i2);
                    Boolean bool = null;
                    if (cCharAt != '-') {
                        if (cCharAt == '0') {
                            bool = Boolean.FALSE;
                        } else if (cCharAt == '1') {
                            bool = Boolean.TRUE;
                        }
                    }
                    enumMap.put((EnumMap) qh8, (Qh8) bool);
                }
                i++;
            }
        }
        return new Xh8(enumMap);
    }

    public static String g(Bundle bundle) {
        String string;
        for (Qh8 qh8 : Qh8.values()) {
            if (bundle.containsKey(qh8.a) && (string = bundle.getString(qh8.a)) != null && n(string) == null) {
                return string;
            }
        }
        return null;
    }

    public static boolean j(int i, int i2) {
        return i <= i2;
    }

    static final int m(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    private static Boolean n(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final Xh8 c(Xh8 xh8) {
        EnumMap enumMap = new EnumMap(Qh8.class);
        for (Qh8 qh8 : Qh8.values()) {
            Boolean boolValueOf = (Boolean) this.a.get(qh8);
            Boolean bool = (Boolean) xh8.a.get(qh8);
            if (boolValueOf == null) {
                boolValueOf = bool;
            } else if (bool != null) {
                boolValueOf = Boolean.valueOf(boolValueOf.booleanValue() && bool.booleanValue());
            }
            enumMap.put((EnumMap) qh8, (Qh8) boolValueOf);
        }
        return new Xh8(enumMap);
    }

    public final Xh8 d(Xh8 xh8) {
        EnumMap enumMap = new EnumMap(Qh8.class);
        for (Qh8 qh8 : Qh8.values()) {
            Boolean bool = (Boolean) this.a.get(qh8);
            if (bool == null) {
                bool = (Boolean) xh8.a.get(qh8);
            }
            enumMap.put((EnumMap) qh8, (Qh8) bool);
        }
        return new Xh8(enumMap);
    }

    public final Boolean e() {
        return (Boolean) this.a.get(Qh8.AD_STORAGE);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Xh8)) {
            return false;
        }
        Xh8 xh8 = (Xh8) obj;
        for (Qh8 qh8 : Qh8.values()) {
            if (m((Boolean) this.a.get(qh8)) != m((Boolean) xh8.a.get(qh8))) {
                return false;
            }
        }
        return true;
    }

    public final Boolean f() {
        return (Boolean) this.a.get(Qh8.ANALYTICS_STORAGE);
    }

    public final String h() {
        StringBuilder sb = new StringBuilder("G1");
        Qh8[] qh8Arr = Qh8.d;
        int length = qh8Arr.length;
        for (int i = 0; i < 2; i++) {
            Boolean bool = (Boolean) this.a.get(qh8Arr[i]);
            sb.append(bool == null ? '-' : bool.booleanValue() ? '1' : '0');
        }
        return sb.toString();
    }

    public final int hashCode() {
        Iterator it = this.a.values().iterator();
        int iM = 17;
        while (it.hasNext()) {
            iM = (iM * 31) + m((Boolean) it.next());
        }
        return iM;
    }

    public final boolean i(Qh8 qh8) {
        Boolean bool = (Boolean) this.a.get(qh8);
        return bool == null || bool.booleanValue();
    }

    public final boolean k(Xh8 xh8) {
        return l(xh8, (Qh8[]) this.a.keySet().toArray(new Qh8[0]));
    }

    public final boolean l(Xh8 xh8, Qh8... qh8Arr) {
        for (Qh8 qh8 : qh8Arr) {
            Boolean bool = (Boolean) this.a.get(qh8);
            Boolean bool2 = (Boolean) xh8.a.get(qh8);
            Boolean bool3 = Boolean.FALSE;
            if (bool == bool3 && bool2 != bool3) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("settings: ");
        Qh8[] qh8ArrValues = Qh8.values();
        int length = qh8ArrValues.length;
        for (int i = 0; i < length; i++) {
            Qh8 qh8 = qh8ArrValues[i];
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(qh8.name());
            sb.append(Separators.EQUALS);
            Boolean bool = (Boolean) this.a.get(qh8);
            if (bool == null) {
                sb.append("uninitialized");
            } else {
                sb.append(true != bool.booleanValue() ? "denied" : "granted");
            }
        }
        return sb.toString();
    }

    public Xh8(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(Qh8.class);
        this.a = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
