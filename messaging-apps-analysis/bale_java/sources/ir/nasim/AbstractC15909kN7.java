package ir.nasim;

/* renamed from: ir.nasim.kN7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC15909kN7 {
    public static final String a(C10639bw6 c10639bw6) {
        AbstractC13042fc3.i(c10639bw6, "state");
        String strM = AbstractC20153rZ6.M(c10639bw6.i(), "-", "", false, 4, null);
        return JF5.g() ? XY6.v(strM) : strM;
    }

    public static final int b(String str) {
        AbstractC13042fc3.i(str, "<this>");
        int iHashCode = str.hashCode();
        if (iHashCode != 3121) {
            if (iHashCode != 3241) {
                if (iHashCode != 3259) {
                    if (iHashCode == 3432 && str.equals("ks")) {
                        return QD5.lang_torki;
                    }
                } else if (str.equals("fa")) {
                    return QD5.lang_farsi;
                }
            } else if (str.equals("en")) {
                return QD5.lang_english;
            }
        } else if (str.equals("ar")) {
            return QD5.lang_arabic;
        }
        return QD5.lang_farsi;
    }
}
