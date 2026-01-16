package ir.nasim;

import okio.ByteString;

/* loaded from: classes3.dex */
public abstract class CY6 {
    public static final int a(String str) {
        if (str == null) {
            return 0;
        }
        return ByteString.INSTANCE.encodeString(str, C12275eL0.b).size();
    }

    public static final String b(String str, int i) {
        AbstractC13042fc3.i(str, "<this>");
        if (a(str) <= i) {
            return str;
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = ((i2 + length) + 1) / 2;
            String strSubstring = str.substring(0, i3);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            if (a(strSubstring) <= i) {
                i2 = i3;
            } else {
                length = i3 - 1;
            }
        }
        String strSubstring2 = str.substring(0, i2);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        return strSubstring2;
    }
}
