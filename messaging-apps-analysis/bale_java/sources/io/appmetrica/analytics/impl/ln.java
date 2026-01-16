package io.appmetrica.analytics.impl;

import java.util.UUID;

/* loaded from: classes3.dex */
public final class ln {
    public static boolean a(String str) {
        UUID uuidFromString;
        if (str == null || str.length() != 32) {
            return false;
        }
        try {
            uuidFromString = UUID.fromString(b(str));
        } catch (Throwable unused) {
            uuidFromString = null;
        }
        return uuidFromString != null;
    }

    public static String b(String str) {
        return str.substring(0, 8) + "-" + str.substring(8, 12) + "-" + str.substring(12, 16) + "-" + str.substring(16, 20) + "-" + str.substring(20, 32);
    }
}
