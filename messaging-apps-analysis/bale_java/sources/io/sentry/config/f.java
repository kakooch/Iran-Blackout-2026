package io.sentry.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface f {
    Map a(String str);

    default Long b(String str) {
        String strF = f(str);
        if (strF != null) {
            try {
                return Long.valueOf(strF);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    default Double c(String str) {
        String strF = f(str);
        if (strF != null) {
            try {
                return Double.valueOf(strF);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    default String d(String str, String str2) {
        String strF = f(str);
        return strF != null ? strF : str2;
    }

    default List e(String str) {
        String strF = f(str);
        return strF != null ? Arrays.asList(strF.split(",")) : Collections.emptyList();
    }

    String f(String str);

    default Boolean g(String str) {
        String strF = f(str);
        if (strF != null) {
            return Boolean.valueOf(strF);
        }
        return null;
    }

    default List h(String str) {
        String strF = f(str);
        if (strF != null) {
            return Arrays.asList(strF.split(","));
        }
        return null;
    }
}
