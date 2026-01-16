package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class PN {
    private final String a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final long i;
    private final Double j;

    public PN(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Double d) {
        AbstractC13042fc3.i(str, "kind");
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        this.h = j7;
        this.i = j8;
        this.j = d;
    }

    public final Double a() {
        return this.j;
    }

    public final long b() {
        return this.h;
    }

    public final long c() {
        return this.i;
    }

    public final long d() {
        return this.g;
    }

    public final long e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PN)) {
            return false;
        }
        PN pn = (PN) obj;
        return AbstractC13042fc3.d(this.a, pn.a) && this.b == pn.b && this.c == pn.c && this.d == pn.d && this.e == pn.e && this.f == pn.f && this.g == pn.g && this.h == pn.h && this.i == pn.i && AbstractC13042fc3.d(this.j, pn.j);
    }

    public long f() {
        return this.c;
    }

    public long g() {
        return this.d;
    }

    public final long h() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31;
        Double d = this.j;
        return iHashCode + (d == null ? 0 : d.hashCode());
    }

    public String toString() {
        return "AudioInBoundTrackStats(kind=" + this.a + ", timestamp=" + this.b + ", jitterBufferDelay=" + this.c + ", jitterBufferEmittedCount=" + this.d + ", packetsDiscarded=" + this.e + ", fecpacketsreceived=" + this.f + ", fecpacketsdiscarded=" + this.g + ", concealedSamples=" + this.h + ", concealmentEvents=" + this.i + ", audioLevel=" + this.j + Separators.RPAREN;
    }
}
