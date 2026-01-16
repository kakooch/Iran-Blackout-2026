package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes5.dex */
public final class SP5 {
    private final C11458d25 a;
    private final long b;
    private final AbstractC24063xz c;
    private final C3933Cz d;
    private final C7880To7 e;
    private final C7234Qv5 f;

    public SP5(C11458d25 c11458d25, long j, AbstractC24063xz abstractC24063xz, C3933Cz c3933Cz, C7880To7 c7880To7, C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(abstractC24063xz, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(c7234Qv5, "promise");
        this.a = c11458d25;
        this.b = j;
        this.c = abstractC24063xz;
        this.d = c3933Cz;
        this.e = c7880To7;
        this.f = c7234Qv5;
    }

    public final C3933Cz a() {
        return this.d;
    }

    public final AbstractC24063xz b() {
        return this.c;
    }

    public final C11458d25 c() {
        return this.a;
    }

    public final C7234Qv5 d() {
        return this.f;
    }

    public final long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SP5)) {
            return false;
        }
        SP5 sp5 = (SP5) obj;
        return AbstractC13042fc3.d(this.a, sp5.a) && this.b == sp5.b && AbstractC13042fc3.d(this.c, sp5.c) && AbstractC13042fc3.d(this.d, sp5.d) && AbstractC13042fc3.d(this.e, sp5.e) && AbstractC13042fc3.d(this.f, sp5.f);
    }

    public final C7880To7 f() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode()) * 31;
        C3933Cz c3933Cz = this.d;
        int iHashCode2 = (iHashCode + (c3933Cz == null ? 0 : c3933Cz.hashCode())) * 31;
        C7880To7 c7880To7 = this.e;
        return ((iHashCode2 + (c7880To7 != null ? c7880To7.hashCode() : 0)) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "Request(peer=" + this.a + ", rid=" + this.b + ", message=" + this.c + ", apiMessageOutReference=" + this.d + ", threadId=" + this.e + ", promise=" + this.f + Separators.RPAREN;
    }
}
