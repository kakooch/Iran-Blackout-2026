package com.google.android.exoplayer2;

import android.os.Looper;
import ir.nasim.AbstractC20011rK;
import ir.nasim.NV0;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class A0 {
    private final b a;
    private final a b;
    private final NV0 c;
    private final J0 d;
    private int e;
    private Object f;
    private Looper g;
    private int h;
    private long i = -9223372036854775807L;
    private boolean j = true;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;

    public interface a {
        void d(A0 a0);
    }

    public interface b {
        void q(int i, Object obj);
    }

    public A0(a aVar, b bVar, J0 j0, int i, NV0 nv0, Looper looper) {
        this.b = aVar;
        this.a = bVar;
        this.d = j0;
        this.g = looper;
        this.c = nv0;
        this.h = i;
    }

    public synchronized boolean a(long j) {
        boolean z;
        try {
            AbstractC20011rK.g(this.k);
            AbstractC20011rK.g(this.g.getThread() != Thread.currentThread());
            long jElapsedRealtime = this.c.elapsedRealtime() + j;
            while (true) {
                z = this.m;
                if (z || j <= 0) {
                    break;
                }
                this.c.b();
                wait(j);
                j = jElapsedRealtime - this.c.elapsedRealtime();
            }
            if (!z) {
                throw new TimeoutException("Message delivery timed out.");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.l;
    }

    public boolean b() {
        return this.j;
    }

    public Looper c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }

    public Object e() {
        return this.f;
    }

    public long f() {
        return this.i;
    }

    public b g() {
        return this.a;
    }

    public J0 h() {
        return this.d;
    }

    public int i() {
        return this.e;
    }

    public synchronized boolean j() {
        return this.n;
    }

    public synchronized void k(boolean z) {
        this.l = z | this.l;
        this.m = true;
        notifyAll();
    }

    public A0 l() {
        AbstractC20011rK.g(!this.k);
        if (this.i == -9223372036854775807L) {
            AbstractC20011rK.a(this.j);
        }
        this.k = true;
        this.b.d(this);
        return this;
    }

    public A0 m(Object obj) {
        AbstractC20011rK.g(!this.k);
        this.f = obj;
        return this;
    }

    public A0 n(int i) {
        AbstractC20011rK.g(!this.k);
        this.e = i;
        return this;
    }
}
