package com.google.ads.interactivemedia.v3.internal;

import android.os.Build;
import android.os.SystemClock;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class apr implements apq {
    static {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                SystemClock.elapsedRealtimeNanos();
            }
        } catch (Throwable unused) {
        }
    }
}
