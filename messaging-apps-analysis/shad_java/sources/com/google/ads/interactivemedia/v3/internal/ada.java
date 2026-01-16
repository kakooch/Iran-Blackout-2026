package com.google.ads.interactivemedia.v3.internal;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ada implements adb {
    public static final acu a;
    public static final acu b;
    private final ExecutorService c;
    private acv<? extends acw> d;
    private IOException e;

    static {
        b(false, -9223372036854775807L);
        b(true, -9223372036854775807L);
        a = new acu(2, -9223372036854775807L);
        b = new acu(3, -9223372036854775807L);
    }

    public ada(String str) {
        this.c = aeu.p(str);
    }

    public static acu b(boolean z, long j) {
        return new acu(z ? 1 : 0, j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adb
    public final void a() throws IOException {
        j(Integer.MIN_VALUE);
    }

    public final boolean c() {
        return this.e != null;
    }

    public final void d() {
        this.e = null;
    }

    public final <T extends acw> long e(T t, act<T> actVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        ary.s(looperMyLooper);
        this.e = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new acv(this, looperMyLooper, t, actVar, i, jElapsedRealtime).b(0L);
        return jElapsedRealtime;
    }

    public final boolean f() {
        return this.d != null;
    }

    public final void g() {
        acv<? extends acw> acvVar = this.d;
        ary.s(acvVar);
        acvVar.c(false);
    }

    public final void h() {
        i(null);
    }

    public final void i(acx acxVar) {
        acv<? extends acw> acvVar = this.d;
        if (acvVar != null) {
            acvVar.c(true);
        }
        if (acxVar != null) {
            this.c.execute(new acy(acxVar));
        }
        this.c.shutdown();
    }

    public final void j(int i) throws IOException {
        IOException iOException = this.e;
        if (iOException != null) {
            throw iOException;
        }
        acv<? extends acw> acvVar = this.d;
        if (acvVar != null) {
            if (i == Integer.MIN_VALUE) {
                i = acvVar.a;
            }
            acvVar.a(i);
        }
    }
}
