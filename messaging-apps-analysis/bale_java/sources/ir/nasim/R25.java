package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class R25 {
    private final int a;
    private final T25 b;
    private final long c;
    private final long d;

    public /* synthetic */ R25(int i, T25 t25, long j, long j2, ED1 ed1) {
        this(i, t25, j, j2);
    }

    public final long a() {
        return this.d;
    }

    public final T25 b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof R25)) {
            return false;
        }
        R25 r25 = (R25) obj;
        return this.a == r25.a && AbstractC13042fc3.d(this.b, r25.b) && this.c == r25.c && AbstractC20975sv0.b(this.d, r25.d);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + AbstractC20975sv0.c(this.d);
    }

    public String toString() {
        return "PeerState(userId=" + this.a + ", peerStatus=" + this.b + ", date=" + this.c + ", callId=" + AbstractC20975sv0.d(this.d) + Separators.RPAREN;
    }

    private R25(int i, T25 t25, long j, long j2) {
        AbstractC13042fc3.i(t25, "peerStatus");
        this.a = i;
        this.b = t25;
        this.c = j;
        this.d = j2;
    }
}
