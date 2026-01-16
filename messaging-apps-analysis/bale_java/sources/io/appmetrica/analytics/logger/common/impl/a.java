package io.appmetrica.analytics.logger.common.impl;

import android.gov.nist.core.Separators;
import android.util.Log;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class a {
    public static String a(String str, String str2, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(Separators.SP);
        if (str2 == null) {
            str2 = "";
        } else if (objArr != null && objArr.length != 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (Throwable th) {
                str2 = "Attention!!! Invalid log format. See exception details above. Message: " + str2 + "; arguments: " + Arrays.toString(objArr);
                Log.e("[LogMessageConstructor]", str2, th);
            }
        }
        sb.append(String.format(Locale.US, "[%d-%s] %s", Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), str2));
        return sb.toString();
    }
}
