package ir.nasim;

import java.util.Locale;

/* renamed from: ir.nasim.bd8, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10451bd8 {
    public static final String a(char c) {
        String strValueOf = String.valueOf(c);
        AbstractC13042fc3.g(strValueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = strValueOf.toUpperCase(locale);
        AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c));
        }
        if (c == 329) {
            return upperCase;
        }
        char cCharAt = upperCase.charAt(0);
        AbstractC13042fc3.g(upperCase, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = upperCase.substring(1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        AbstractC13042fc3.g(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return cCharAt + lowerCase;
    }
}
