package j$.util;

import java.util.TimeZone;

/* loaded from: classes2.dex */
public class DesugarTimeZone {
    private DesugarTimeZone() {
    }

    public static TimeZone getTimeZone(String str) {
        return TimeZone.getTimeZone(str);
    }
}
