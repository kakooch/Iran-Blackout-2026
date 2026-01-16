package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class DE7 extends AbstractC20556sC7 {
    private final C11458d25 a;
    private final long b;
    private final AbstractC24063xz c;
    private final Long d;
    private final int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DE7(C11458d25 c11458d25, long j, AbstractC24063xz abstractC24063xz, Long l, int i) {
        super(null);
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = c11458d25;
        this.b = j;
        this.c = abstractC24063xz;
        this.d = l;
        this.e = i;
    }

    public final Long a() {
        return this.d;
    }

    public final AbstractC24063xz b() {
        return this.c;
    }

    public final C11458d25 c() {
        return this.a;
    }

    public final long d() {
        return this.b;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DE7)) {
            return false;
        }
        DE7 de7 = (DE7) obj;
        return AbstractC13042fc3.d(this.a, de7.a) && this.b == de7.b && AbstractC13042fc3.d(this.c, de7.c) && AbstractC13042fc3.d(this.d, de7.d) && this.e == de7.e;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31;
        AbstractC24063xz abstractC24063xz = this.c;
        int iHashCode2 = (iHashCode + (abstractC24063xz == null ? 0 : abstractC24063xz.hashCode())) * 31;
        Long l = this.d;
        return ((iHashCode2 + (l != null ? l.hashCode() : 0)) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        return "UpdateMessageContentChanged(peer=" + this.a + ", rid=" + this.b + ", message=" + this.c + ", date=" + this.d + ", updaterUserId=" + this.e + Separators.RPAREN;
    }
}
