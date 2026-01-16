package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aes {
    private long a;
    private long b;
    private volatile long c = -9223372036854775807L;

    public aes(long j) {
        a(j);
    }

    public static long i(long j) {
        return (j * 1000000) / 90000;
    }

    public static long j(long j) {
        return (j * 90000) / 1000000;
    }

    public final synchronized void a(long j) {
        ary.q(this.c == -9223372036854775807L);
        this.a = j;
    }

    public final long b() {
        return this.a;
    }

    public final long c() {
        if (this.c != -9223372036854775807L) {
            return this.b + this.c;
        }
        long j = this.a;
        if (j == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j;
    }

    public final long d() {
        if (this.a == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.b;
    }

    public final void e() {
        this.c = -9223372036854775807L;
    }

    public final long f(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.c != -9223372036854775807L) {
            long j2 = j(this.c);
            long j3 = (4294967296L + j2) / 8589934592L;
            long j4 = (((-1) + j3) * 8589934592L) + j;
            j += j3 * 8589934592L;
            if (Math.abs(j4 - j2) < Math.abs(j - j2)) {
                j = j4;
            }
        }
        return g(i(j));
    }

    public final long g(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.c != -9223372036854775807L) {
            this.c = j;
        } else {
            long j2 = this.a;
            if (j2 != Long.MAX_VALUE) {
                this.b = j2 - j;
            }
            synchronized (this) {
                this.c = j;
                notifyAll();
            }
        }
        return j + this.b;
    }

    public final synchronized void h() throws InterruptedException {
        while (this.c == -9223372036854775807L) {
            wait();
        }
    }
}
