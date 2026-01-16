package ir.nasim;

import java.util.Iterator;

/* loaded from: classes8.dex */
public abstract class BF0 {
    public static final String a(String str) {
        char cCharAt;
        AbstractC13042fc3.i(str, "<this>");
        if (str.length() == 0 || 'a' > (cCharAt = str.charAt(0)) || cCharAt > 'z') {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        String strSubstring = str.substring(1);
        AbstractC13042fc3.h(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(upperCase) + strSubstring;
    }

    public static final String b(String str) {
        char cCharAt;
        AbstractC13042fc3.i(str, "<this>");
        if (str.length() == 0 || 'A' > (cCharAt = str.charAt(0)) || cCharAt > 'Z') {
            return str;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        String strSubstring = str.substring(1);
        AbstractC13042fc3.h(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(lowerCase) + strSubstring;
    }

    public static final String c(String str, boolean z) {
        Object next;
        AbstractC13042fc3.i(str, "<this>");
        if (str.length() == 0 || !d(str, 0, z)) {
            return str;
        }
        if (str.length() == 1 || !d(str, 1, z)) {
            return z ? b(str) : AbstractC20153rZ6.z(str);
        }
        Iterator it = AbstractC20762sZ6.e0(str).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!d(str, ((Number) next).intValue(), z)) {
                break;
            }
        }
        Integer num = (Integer) next;
        if (num == null) {
            return e(str, z);
        }
        int iIntValue = num.intValue() - 1;
        String strSubstring = str.substring(0, iIntValue);
        AbstractC13042fc3.h(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strE = e(strSubstring, z);
        String strSubstring2 = str.substring(iIntValue);
        AbstractC13042fc3.h(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return AbstractC13042fc3.q(strE, strSubstring2);
    }

    private static final boolean d(String str, int i, boolean z) {
        char cCharAt = str.charAt(i);
        return z ? 'A' <= cCharAt && cCharAt <= 'Z' : Character.isUpperCase(cCharAt);
    }

    private static final String e(String str, boolean z) {
        if (z) {
            return f(str);
        }
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        AbstractC13042fc3.h(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    public static final String f(String str) {
        AbstractC13042fc3.i(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            i++;
            if ('A' <= cCharAt && cCharAt <= 'Z') {
                cCharAt = Character.toLowerCase(cCharAt);
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "builder.toString()");
        return string;
    }
}
