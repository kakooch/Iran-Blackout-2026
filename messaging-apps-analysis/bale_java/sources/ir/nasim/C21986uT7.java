package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.uT7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21986uT7 {
    private final String a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final long i;
    private final long j;
    private final double k;
    private final long l;
    private final long m;
    private final long n;
    private final long o;
    private final String p;
    private final long q;

    public C21986uT7(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, double d, long j10, long j11, long j12, long j13, String str2, long j14) {
        AbstractC13042fc3.i(str, "kind");
        AbstractC13042fc3.i(str2, "decoderImplementation");
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        this.h = j7;
        this.i = j8;
        this.j = j9;
        this.k = d;
        this.l = j10;
        this.m = j11;
        this.n = j12;
        this.o = j13;
        this.p = str2;
        this.q = j14;
    }

    public final String a() {
        return this.p;
    }

    public final long b() {
        return this.m;
    }

    public final long c() {
        return this.e;
    }

    public final long d() {
        return this.f;
    }

    public final long e() {
        return this.o;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21986uT7)) {
            return false;
        }
        C21986uT7 c21986uT7 = (C21986uT7) obj;
        return AbstractC13042fc3.d(this.a, c21986uT7.a) && this.b == c21986uT7.b && this.c == c21986uT7.c && this.d == c21986uT7.d && this.e == c21986uT7.e && this.f == c21986uT7.f && this.g == c21986uT7.g && this.h == c21986uT7.h && this.i == c21986uT7.i && this.j == c21986uT7.j && Double.compare(this.k, c21986uT7.k) == 0 && this.l == c21986uT7.l && this.m == c21986uT7.m && this.n == c21986uT7.n && this.o == c21986uT7.o && AbstractC13042fc3.d(this.p, c21986uT7.p) && this.q == c21986uT7.q;
    }

    public final long f() {
        return this.i;
    }

    public long g() {
        return this.c;
    }

    public long h() {
        return this.d;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31) + Double.hashCode(this.k)) * 31) + Long.hashCode(this.l)) * 31) + Long.hashCode(this.m)) * 31) + Long.hashCode(this.n)) * 31) + Long.hashCode(this.o)) * 31) + this.p.hashCode()) * 31) + Long.hashCode(this.q);
    }

    public final double i() {
        return this.k;
    }

    public final long j() {
        return this.l;
    }

    public final long k() {
        return this.g;
    }

    public final long l() {
        return this.n;
    }

    public final long m() {
        return this.q;
    }

    public final long n() {
        return this.h;
    }

    public final long o() {
        return this.j;
    }

    public String toString() {
        return "VideoInBoundTrackStats(kind=" + this.a + ", timestamp=" + this.b + ", jitterBufferDelay=" + this.c + ", jitterBufferEmittedCount=" + this.d + ", framesDropped=" + this.e + ", framesPerSecond=" + this.f + ", pauseCount=" + this.g + ", totalPausesDuration=" + this.h + ", freezeCount=" + this.i + ", totalfreezesduration=" + this.j + ", lastpacketreceivedtimestamp=" + this.k + ", nackCount=" + this.l + ", firCount=" + this.m + ", pliCount=" + this.n + ", framesReceived=" + this.o + ", decoderImplementation=" + this.p + ", retransmittedPacketsReceived=" + this.q + Separators.RPAREN;
    }
}
