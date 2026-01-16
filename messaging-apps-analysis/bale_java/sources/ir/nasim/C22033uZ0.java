package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.uZ0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22033uZ0 {
    private final long a;
    private final long b;
    private final Integer c;

    public C22033uZ0(long j, long j2, Integer num) {
        this.a = j;
        this.b = j2;
        this.c = num;
    }

    public final Integer a() {
        return this.c;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22033uZ0)) {
            return false;
        }
        C22033uZ0 c22033uZ0 = (C22033uZ0) obj;
        return this.a == c22033uZ0.a && this.b == c22033uZ0.b && AbstractC13042fc3.d(this.c, c22033uZ0.c);
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31;
        Integer num = this.c;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "CommentInfo(topId=" + this.a + ", topDate=" + this.b + ", peerId=" + this.c + Separators.RPAREN;
    }
}
