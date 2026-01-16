package io.sentry.util;

import android.gov.nist.core.Separators;
import io.sentry.ILogger;
import io.sentry.Y2;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class B {
    private static final Charset a = Charset.forName("UTF-8");
    private static final Pattern b = Pattern.compile("[\\W_]+");

    public static String a(String str, ILogger iLogger) {
        if (str != null && !str.isEmpty()) {
            try {
                return new StringBuilder(new BigInteger(1, MessageDigest.getInstance("SHA-1").digest(str.getBytes(a))).toString(16)).toString();
            } catch (NoSuchAlgorithmException e) {
                iLogger.b(Y2.INFO, "SHA-1 isn't available to calculate the hash.", e);
            } catch (Throwable th) {
                iLogger.c(Y2.INFO, "string: %s could not calculate its hash", th, str);
            }
        }
        return null;
    }

    public static String b(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] strArrSplit = b.split(str, -1);
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            sb.append(c(str2));
        }
        return sb.toString();
    }

    public static String c(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        Locale locale = Locale.ROOT;
        sb.append(strSubstring.toUpperCase(locale));
        sb.append(str.substring(1).toLowerCase(locale));
        return sb.toString();
    }

    public static String d(String str) {
        int i;
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(Separators.DOT);
        return (iLastIndexOf < 0 || str.length() <= (i = iLastIndexOf + 1)) ? str : str.substring(i);
    }

    public static String e(String str) {
        return str.equals("0000-0000") ? "00000000-0000-0000-0000-000000000000" : str;
    }

    public static String f(String str, String str2) {
        return (str == null || str2 == null || !str.startsWith(str2) || !str.endsWith(str2)) ? str : str.substring(str2.length(), str.length() - str2.length());
    }

    public static String g(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }
}
