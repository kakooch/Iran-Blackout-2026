package io.sentry.android.core;

/* loaded from: classes3.dex */
final class Q0 {
    private int a;
    private int b;
    private long c;
    private long d;
    private long e;

    public void a(long j, long j2, boolean z, boolean z2) {
        this.e += j;
        if (z2) {
            this.d += j2;
            this.b++;
        } else if (z) {
            this.c += j2;
            this.a++;
        }
    }

    public int b() {
        return this.b;
    }

    public long c() {
        return this.d;
    }

    public int d() {
        return this.a;
    }

    public long e() {
        return this.c;
    }

    public int f() {
        return this.a + this.b;
    }

    public long g() {
        return this.e;
    }
}
