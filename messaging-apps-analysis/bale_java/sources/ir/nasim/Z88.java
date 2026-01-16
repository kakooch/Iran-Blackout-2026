package ir.nasim;

import android.gov.nist.core.Separators;
import com.google.android.exoplayer2.ParserException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public abstract class Z88 {
    private static final Pattern a = Pattern.compile("^NOTE([ \t].*)?$");

    public static Matcher a(EW4 ew4) {
        String strQ;
        while (true) {
            String strQ2 = ew4.q();
            if (strQ2 == null) {
                return null;
            }
            if (a.matcher(strQ2).matches()) {
                do {
                    strQ = ew4.q();
                    if (strQ != null) {
                    }
                } while (!strQ.isEmpty());
            } else {
                Matcher matcher = W88.a.matcher(strQ2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(EW4 ew4) {
        String strQ = ew4.q();
        return strQ != null && strQ.startsWith("WEBVTT");
    }

    public static float c(String str) {
        if (str.endsWith(Separators.PERCENT)) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) {
        String[] strArrS0 = AbstractC9683aN7.S0(str, "\\.");
        long j = 0;
        for (String str2 : AbstractC9683aN7.R0(strArrS0[0], ":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (strArrS0.length == 2) {
            j2 += Long.parseLong(strArrS0[1]);
        }
        return j2 * 1000;
    }

    public static void e(EW4 ew4) throws ParserException {
        int iF = ew4.f();
        if (b(ew4)) {
            return;
        }
        ew4.S(iF);
        throw ParserException.a("Expected WEBVTT. Got " + ew4.q(), null);
    }
}
