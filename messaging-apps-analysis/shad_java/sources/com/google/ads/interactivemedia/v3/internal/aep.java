package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aep implements adk {
    protected aep() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adk
    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adk
    public final long b() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adk
    public final adp c(Looper looper, Handler.Callback callback) {
        return new aeq(new Handler(looper, callback));
    }
}
