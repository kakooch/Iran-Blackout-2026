package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class asr {
    static {
        Math.log(2.0d);
    }

    public static boolean a(double d) {
        return Math.copySign(1.0d - d, 1.0d) <= 0.1d || d == 1.0d || (Double.isNaN(1.0d) && Double.isNaN(d));
    }
}
