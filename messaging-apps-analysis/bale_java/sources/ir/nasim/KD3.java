package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class KD3 {
    private final C11458d25 a;
    private final Long b;

    public KD3(C11458d25 c11458d25, Long l) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = c11458d25;
        this.b = l;
    }

    public final Long a() {
        return this.b;
    }

    public final C11458d25 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KD3)) {
            return false;
        }
        KD3 kd3 = (KD3) obj;
        return AbstractC13042fc3.d(this.a, kd3.a) && AbstractC13042fc3.d(this.b, kd3.b);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Long l = this.b;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "LiveStreamMessage(peer=" + this.a + ", liveKey=" + this.b + Separators.RPAREN;
    }
}
