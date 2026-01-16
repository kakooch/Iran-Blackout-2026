package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class XN implements LM4 {
    private final String a;
    private final FW0 b;
    private final long c;
    private final AbstractC17786nZ3 d;
    private final AbstractC18271oN5 e;
    private final long f;

    public XN(String str, FW0 fw0, long j, AbstractC17786nZ3 abstractC17786nZ3, AbstractC18271oN5 abstractC18271oN5, long j2) {
        AbstractC13042fc3.i(str, "kind");
        this.a = str;
        this.b = fw0;
        this.c = j;
        this.d = abstractC17786nZ3;
        this.e = abstractC18271oN5;
        this.f = j2;
    }

    @Override // ir.nasim.LM4
    public FW0 a() {
        return this.b;
    }

    @Override // ir.nasim.LM4
    public long b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XN)) {
            return false;
        }
        XN xn = (XN) obj;
        return AbstractC13042fc3.d(this.a, xn.a) && AbstractC13042fc3.d(this.b, xn.b) && this.c == xn.c && AbstractC13042fc3.d(this.d, xn.d) && AbstractC13042fc3.d(this.e, xn.e) && this.f == xn.f;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        FW0 fw0 = this.b;
        int iHashCode2 = (((iHashCode + (fw0 == null ? 0 : fw0.hashCode())) * 31) + Long.hashCode(this.c)) * 31;
        AbstractC17786nZ3 abstractC17786nZ3 = this.d;
        int iHashCode3 = (iHashCode2 + (abstractC17786nZ3 == null ? 0 : abstractC17786nZ3.hashCode())) * 31;
        AbstractC18271oN5 abstractC18271oN5 = this.e;
        return ((iHashCode3 + (abstractC18271oN5 != null ? abstractC18271oN5.hashCode() : 0)) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "AudioOutBoundTrackStats(kind=" + this.a + ", codec=" + this.b + ", packetSend=" + this.c + ", sourceKind=" + this.d + ", remoteRTP=" + this.e + ", timestamp=" + this.f + Separators.RPAREN;
    }
}
