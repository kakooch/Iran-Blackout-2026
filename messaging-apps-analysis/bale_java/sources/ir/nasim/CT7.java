package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class CT7 implements LM4 {
    private final String a;
    private final FW0 b;
    private final long c;
    private final AbstractC17786nZ3 d;
    private final AbstractC18271oN5 e;
    private final long f;
    private final long g;
    private final long h;
    private final long i;
    private final long j;
    private final long k;
    private final long l;
    private final long m;
    private final String n;

    public CT7(String str, FW0 fw0, long j, AbstractC17786nZ3 abstractC17786nZ3, AbstractC18271oN5 abstractC18271oN5, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, String str2) {
        AbstractC13042fc3.i(str, "kind");
        AbstractC13042fc3.i(str2, "scalabilityMode");
        this.a = str;
        this.b = fw0;
        this.c = j;
        this.d = abstractC17786nZ3;
        this.e = abstractC18271oN5;
        this.f = j2;
        this.g = j3;
        this.h = j4;
        this.i = j5;
        this.j = j6;
        this.k = j7;
        this.l = j8;
        this.m = j9;
        this.n = str2;
    }

    @Override // ir.nasim.LM4
    public FW0 a() {
        return this.b;
    }

    @Override // ir.nasim.LM4
    public long b() {
        return this.c;
    }

    public final long c() {
        return this.l;
    }

    public final long d() {
        return this.i;
    }

    public final long e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CT7)) {
            return false;
        }
        CT7 ct7 = (CT7) obj;
        return AbstractC13042fc3.d(this.a, ct7.a) && AbstractC13042fc3.d(this.b, ct7.b) && this.c == ct7.c && AbstractC13042fc3.d(this.d, ct7.d) && AbstractC13042fc3.d(this.e, ct7.e) && this.f == ct7.f && this.g == ct7.g && this.h == ct7.h && this.i == ct7.i && this.j == ct7.j && this.k == ct7.k && this.l == ct7.l && this.m == ct7.m && AbstractC13042fc3.d(this.n, ct7.n);
    }

    public final long f() {
        return this.k;
    }

    public final long g() {
        return this.m;
    }

    public final long h() {
        return this.g;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        FW0 fw0 = this.b;
        int iHashCode2 = (((iHashCode + (fw0 == null ? 0 : fw0.hashCode())) * 31) + Long.hashCode(this.c)) * 31;
        AbstractC17786nZ3 abstractC17786nZ3 = this.d;
        int iHashCode3 = (iHashCode2 + (abstractC17786nZ3 == null ? 0 : abstractC17786nZ3.hashCode())) * 31;
        AbstractC18271oN5 abstractC18271oN5 = this.e;
        return ((((((((((((((((((iHashCode3 + (abstractC18271oN5 != null ? abstractC18271oN5.hashCode() : 0)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31) + Long.hashCode(this.k)) * 31) + Long.hashCode(this.l)) * 31) + Long.hashCode(this.m)) * 31) + this.n.hashCode();
    }

    public final String i() {
        return this.n;
    }

    public AbstractC17786nZ3 j() {
        return this.d;
    }

    public final long k() {
        return this.h;
    }

    public String toString() {
        return "VideoOutBoundTrackStats(kind=" + this.a + ", codec=" + this.b + ", packetSend=" + this.c + ", sourceKind=" + this.d + ", remoteRTP=" + this.e + ", timestamp=" + this.f + ", retransmittedPacketsSent=" + this.g + ", targetBitrate=" + this.h + ", framesSent=" + this.i + ", hugeFramesSent=" + this.j + ", nackCount=" + this.k + ", firCount=" + this.l + ", pliCount=" + this.m + ", scalabilityMode=" + this.n + Separators.RPAREN;
    }
}
