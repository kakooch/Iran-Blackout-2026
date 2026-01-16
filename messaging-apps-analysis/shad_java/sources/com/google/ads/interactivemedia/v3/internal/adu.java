package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class adu {
    private static final boolean a = true;

    public static void a(String str, String str2, Throwable th) {
        Log.w(str, c(str2, th));
    }

    public static void b(String str, String str2, Throwable th) {
        Log.e(str, c(str2, th));
    }

    private static String c(String str, Throwable th) {
        String strReplace;
        if (th != null) {
            Throwable cause = th;
            while (true) {
                if (cause == null) {
                    strReplace = Log.getStackTraceString(th).trim().replace("\t", "    ");
                    break;
                }
                if (cause instanceof UnknownHostException) {
                    strReplace = "UnknownHostException (no network)";
                    break;
                }
                cause = cause.getCause();
            }
        } else {
            strReplace = null;
        }
        if (TextUtils.isEmpty(strReplace)) {
            return str;
        }
        String strValueOf = String.valueOf(str);
        String strReplace2 = strReplace.replace("\n", "\n  ");
        StringBuilder sb = new StringBuilder(strValueOf.length() + 4 + String.valueOf(strReplace2).length());
        sb.append(strValueOf);
        sb.append("\n  ");
        sb.append(strReplace2);
        sb.append('\n');
        return sb.toString();
    }
}
