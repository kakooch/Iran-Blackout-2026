package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC22767vn5;

/* renamed from: ir.nasim.fl5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13161fl5 {
    private final boolean a;
    private final long b;
    private final AbstractC22767vn5 c;

    public C13161fl5(boolean z, long j, AbstractC22767vn5 abstractC22767vn5) {
        AbstractC13042fc3.i(abstractC22767vn5, "state");
        this.a = z;
        this.b = j;
        this.c = abstractC22767vn5;
    }

    public static /* synthetic */ C13161fl5 b(C13161fl5 c13161fl5, boolean z, long j, AbstractC22767vn5 abstractC22767vn5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = c13161fl5.a;
        }
        if ((i & 2) != 0) {
            j = c13161fl5.b;
        }
        if ((i & 4) != 0) {
            abstractC22767vn5 = c13161fl5.c;
        }
        return c13161fl5.a(z, j, abstractC22767vn5);
    }

    public final C13161fl5 a(boolean z, long j, AbstractC22767vn5 abstractC22767vn5) {
        AbstractC13042fc3.i(abstractC22767vn5, "state");
        return new C13161fl5(z, j, abstractC22767vn5);
    }

    public final long c() {
        return this.b;
    }

    public final AbstractC22767vn5 d() {
        return this.c;
    }

    public final boolean e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13161fl5)) {
            return false;
        }
        C13161fl5 c13161fl5 = (C13161fl5) obj;
        return this.a == c13161fl5.a && this.b == c13161fl5.b && AbstractC13042fc3.d(this.c, c13161fl5.c);
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "PremiumData(isPremium=" + this.a + ", expiredTime=" + this.b + ", state=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C13161fl5(boolean z, long j, AbstractC22767vn5 abstractC22767vn5, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? AbstractC22767vn5.b.a : abstractC22767vn5);
    }
}
