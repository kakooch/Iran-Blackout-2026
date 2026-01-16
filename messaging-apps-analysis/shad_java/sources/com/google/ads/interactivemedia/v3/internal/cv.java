package com.google.ads.interactivemedia.v3.internal;

import android.os.Build;
import java.util.HashSet;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class cv {
    public static final String a;
    private static final HashSet<String> b;
    private static String c;

    static {
        String str = Build.VERSION.RELEASE;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56);
        sb.append("ExoPlayerLib/2.12.1 (Linux;Android ");
        sb.append(str);
        sb.append(") ");
        sb.append("ExoPlayerLib/2.12.1");
        a = sb.toString();
        b = new HashSet<>();
        c = "goog.exo.core";
    }

    public static synchronized String a() {
        return c;
    }

    public static synchronized void b(String str) {
        if (b.add(str)) {
            String str2 = c;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 2 + str.length());
            sb.append(str2);
            sb.append(", ");
            sb.append(str);
            c = sb.toString();
        }
    }
}
