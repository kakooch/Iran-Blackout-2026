package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class WE7 extends AbstractC20556sC7 {
    private final C11458d25 a;
    private final long b;
    private final long c;
    private final C3460Az d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WE7(C11458d25 c11458d25, long j, long j2, C3460Az c3460Az) {
        super(null);
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = c11458d25;
        this.b = j;
        this.c = j2;
        this.d = c3460Az;
    }

    public final long a() {
        return this.c;
    }

    public final C11458d25 b() {
        return this.a;
    }

    public final C3460Az c() {
        return this.d;
    }

    public final long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WE7)) {
            return false;
        }
        WE7 we7 = (WE7) obj;
        return AbstractC13042fc3.d(this.a, we7.a) && this.b == we7.b && this.c == we7.c && AbstractC13042fc3.d(this.d, we7.d);
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31;
        C3460Az c3460Az = this.d;
        return iHashCode + (c3460Az == null ? 0 : c3460Az.hashCode());
    }

    public String toString() {
        return "UpdateMessageSent(peer=" + this.a + ", rid=" + this.b + ", date=" + this.c + ", previousMessageId=" + this.d + Separators.RPAREN;
    }
}
