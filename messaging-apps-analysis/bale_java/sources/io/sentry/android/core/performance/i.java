package io.sentry.android.core.performance;

import android.os.SystemClock;
import io.sentry.AbstractC3124h2;
import io.sentry.AbstractC3141l;
import io.sentry.C3110e3;

/* loaded from: classes3.dex */
public class i implements Comparable {
    private String a;
    private long b;
    private long c;
    private long d;

    public void A(String str, long j, long j2, long j3) {
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = j3;
    }

    public void B() {
        this.c = SystemClock.uptimeMillis();
        this.b = System.currentTimeMillis();
    }

    public void C() {
        this.d = SystemClock.uptimeMillis();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        return Long.compare(this.b, iVar.b);
    }

    public String h() {
        return this.a;
    }

    public long i() {
        if (x()) {
            return this.d - this.c;
        }
        return 0L;
    }

    public AbstractC3124h2 j() {
        if (x()) {
            return new C3110e3(AbstractC3141l.i(o()));
        }
        return null;
    }

    public long o() {
        if (w()) {
            return this.b + i();
        }
        return 0L;
    }

    public double p() {
        return AbstractC3141l.j(o());
    }

    public AbstractC3124h2 q() {
        if (w()) {
            return new C3110e3(AbstractC3141l.i(r()));
        }
        return null;
    }

    public long r() {
        return this.b;
    }

    public double s() {
        return AbstractC3141l.j(this.b);
    }

    public long t() {
        return this.c;
    }

    public boolean u() {
        return this.c == 0;
    }

    public boolean v() {
        return this.d == 0;
    }

    public boolean w() {
        return this.c != 0;
    }

    public boolean x() {
        return this.d != 0;
    }

    public void y() {
        this.a = null;
        this.c = 0L;
        this.d = 0L;
        this.b = 0L;
    }

    public void z(long j) {
        this.c = j;
        this.b = System.currentTimeMillis() - (SystemClock.uptimeMillis() - this.c);
    }
}
