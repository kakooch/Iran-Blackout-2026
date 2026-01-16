package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public final class CW4 {
    private final int a;
    private final long b;
    private final long c;
    private final Long d;

    public CW4(int i, long j, long j2, Long l) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = l;
    }

    public final long a() {
        return this.c;
    }

    public final int b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CW4)) {
            return false;
        }
        CW4 cw4 = (CW4) obj;
        return this.a == cw4.a && this.b == cw4.b && this.c == cw4.c && AbstractC13042fc3.d(this.d, cw4.d);
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31;
        Long l = this.d;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "ParentPostId(parentPeerId=" + this.a + ", parentRid=" + this.b + ", parentMessageDate=" + this.c + ", groupedId=" + this.d + Separators.RPAREN;
    }
}
