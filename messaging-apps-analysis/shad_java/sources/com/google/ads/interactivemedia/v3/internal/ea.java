package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.SystemClock;
import java.util.concurrent.TimeoutException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ea {
    private final dz a;
    private final dy b;
    private final es c;
    private int d;
    private Object e;
    private final Handler f;
    private final int g;
    private final long h = -9223372036854775807L;
    private final boolean i = true;
    private boolean j;
    private boolean k;
    private boolean l;

    public ea(dy dyVar, dz dzVar, es esVar, int i, Handler handler) {
        this.b = dyVar;
        this.a = dzVar;
        this.c = esVar;
        this.f = handler;
        this.g = i;
    }

    public final es a() {
        return this.c;
    }

    public final dz b() {
        return this.a;
    }

    public final int c() {
        return this.d;
    }

    public final Object d() {
        return this.e;
    }

    public final Handler e() {
        return this.f;
    }

    public final long f() {
        return -9223372036854775807L;
    }

    public final int g() {
        return this.g;
    }

    public final boolean h() {
        return true;
    }

    public final synchronized boolean i() {
        return false;
    }

    public final synchronized void j(boolean z) {
        this.k = z | this.k;
        this.l = true;
        notifyAll();
    }

    public final synchronized void k(long j) throws InterruptedException, TimeoutException {
        l(j);
    }

    final synchronized boolean l(long j) throws InterruptedException, TimeoutException {
        ary.q(this.j);
        ary.q(this.f.getLooper().getThread() != Thread.currentThread());
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j;
        while (!this.l) {
            if (j <= 0) {
                throw new TimeoutException("Message delivery timed out.");
            }
            wait(j);
            j = jElapsedRealtime - SystemClock.elapsedRealtime();
        }
        return this.k;
    }

    public final void m() {
        ary.q(!this.j);
        ary.o(true);
        this.j = true;
        this.b.g(this);
    }

    public final void n(Object obj) {
        ary.q(!this.j);
        this.e = obj;
    }

    public final void o(int i) {
        ary.q(!this.j);
        this.d = i;
    }
}
