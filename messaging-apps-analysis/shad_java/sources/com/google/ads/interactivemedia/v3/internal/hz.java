package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import java.lang.Exception;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class hz<T extends Exception> {
    private T a;
    private long b;

    public final void a(T t) throws Exception {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.a == null) {
            this.a = t;
            this.b = 100 + jElapsedRealtime;
        }
        if (jElapsedRealtime >= this.b) {
            T t2 = this.a;
            if (t2 != t) {
                auf.a(t2, t);
            }
            T t3 = this.a;
            b();
            throw t3;
        }
    }

    public final void b() {
        this.a = null;
    }
}
