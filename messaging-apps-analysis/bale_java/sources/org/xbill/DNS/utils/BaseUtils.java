package org.xbill.DNS.utils;

import android.gov.nist.core.Separators;
import lombok.Generated;

/* loaded from: classes8.dex */
final class BaseUtils {
    @Generated
    private BaseUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static String wrapLines(String str, int i, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < str.length()) {
            sb.append(str2);
            int i3 = i2 + i;
            if (i3 >= str.length()) {
                sb.append(str.substring(i2));
                if (z) {
                    sb.append(" )");
                }
            } else {
                sb.append((CharSequence) str, i2, i3);
                sb.append(Separators.RETURN);
            }
            i2 = i3;
        }
        return sb.toString();
    }
}
