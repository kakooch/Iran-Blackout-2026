package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class RE7 extends AbstractC20556sC7 {
    private final C11458d25 a;
    private final long b;
    private final Integer c;
    private final Long d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RE7(C11458d25 c11458d25, long j, Integer num, Long l) {
        super(null);
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = c11458d25;
        this.b = j;
        this.c = num;
        this.d = l;
    }

    public final Long a() {
        return this.d;
    }

    public final C11458d25 b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public final Integer d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RE7)) {
            return false;
        }
        RE7 re7 = (RE7) obj;
        return AbstractC13042fc3.d(this.a, re7.a) && this.b == re7.b && AbstractC13042fc3.d(this.c, re7.c) && AbstractC13042fc3.d(this.d, re7.d);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31;
        Integer num = this.c;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.d;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "UpdateMessageReadByMe(peer=" + this.a + ", startDate=" + this.b + ", unreadCounter=" + this.c + ", endDate=" + this.d + Separators.RPAREN;
    }
}
