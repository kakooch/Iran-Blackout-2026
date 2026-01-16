package ir.nasim;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.cL0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10868cL0 {
    public static int a(int i) {
        if (2 <= i && i < 37) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new C24411ya3(2, 36));
    }

    public static final int b(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static XJ0 c(char c) {
        return XJ0.c.a(Character.getType(c));
    }

    public static boolean d(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    public static String e(char c, Locale locale) {
        AbstractC13042fc3.i(locale, CommonUrlParts.LOCALE);
        String strF = f(c, locale);
        if (strF.length() <= 1) {
            String strValueOf = String.valueOf(c);
            AbstractC13042fc3.g(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
            return !AbstractC13042fc3.d(strF, upperCase) ? strF : String.valueOf(Character.toTitleCase(c));
        }
        if (c == 329) {
            return strF;
        }
        char cCharAt = strF.charAt(0);
        AbstractC13042fc3.g(strF, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strF.substring(1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        AbstractC13042fc3.g(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return cCharAt + lowerCase;
    }

    public static final String f(char c, Locale locale) {
        AbstractC13042fc3.i(locale, CommonUrlParts.LOCALE);
        String strValueOf = String.valueOf(c);
        AbstractC13042fc3.g(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(locale);
        AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
