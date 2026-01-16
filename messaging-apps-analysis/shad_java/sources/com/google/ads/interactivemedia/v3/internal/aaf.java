package com.google.ads.interactivemedia.v3.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aaf {
    private static final Pattern a = Pattern.compile("^NOTE([ \t].*)?$");

    public static void a(aee aeeVar) throws dt {
        int iG = aeeVar.g();
        if (b(aeeVar)) {
            return;
        }
        aeeVar.h(iG);
        String strValueOf = String.valueOf(aeeVar.I());
        throw new dt(strValueOf.length() != 0 ? "Expected WEBVTT. Got ".concat(strValueOf) : new String("Expected WEBVTT. Got "));
    }

    public static boolean b(aee aeeVar) {
        String strI = aeeVar.I();
        return strI != null && strI.startsWith("WEBVTT");
    }

    public static long c(String str) throws NumberFormatException {
        String[] strArrA = aeu.A(str, "\\.");
        long j = 0;
        for (String str2 : aeu.z(strArrA[0], ":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (strArrA.length == 2) {
            j2 += Long.parseLong(strArrA[1]);
        }
        return j2 * 1000;
    }

    public static Matcher d(aee aeeVar) {
        String strI;
        while (true) {
            String strI2 = aeeVar.I();
            if (strI2 == null) {
                return null;
            }
            if (a.matcher(strI2).matches()) {
                do {
                    strI = aeeVar.I();
                    if (strI != null) {
                    }
                } while (!strI.isEmpty());
            } else {
                Matcher matcher = aae.a.matcher(strI2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }
}
