package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class KD7 extends AbstractC20556sC7 {
    private final int a;
    private final long b;
    private final int c;
    private final C6984Pv d;
    private final long e;

    public KD7(int i, long j, int i2, C6984Pv c6984Pv, long j2) {
        super(null);
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = c6984Pv;
        this.e = j2;
    }

    public final C6984Pv a() {
        return this.d;
    }

    public final long b() {
        return this.e;
    }

    public final int c() {
        return this.a;
    }

    public final long d() {
        return this.b;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KD7)) {
            return false;
        }
        KD7 kd7 = (KD7) obj;
        return this.a == kd7.a && this.b == kd7.b && this.c == kd7.c && AbstractC13042fc3.d(this.d, kd7.d) && this.e == kd7.e;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31;
        C6984Pv c6984Pv = this.d;
        return ((iHashCode + (c6984Pv == null ? 0 : c6984Pv.hashCode())) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "UpdateGroupAvatarChangedObsolete(groupId=" + this.a + ", rid=" + this.b + ", uid=" + this.c + ", avatar=" + this.d + ", date=" + this.e + Separators.RPAREN;
    }
}
