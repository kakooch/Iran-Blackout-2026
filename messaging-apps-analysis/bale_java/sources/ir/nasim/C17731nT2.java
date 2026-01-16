package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.nT2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17731nT2 {
    private final AbstractC20556sC7 a;
    private final long b;

    public C17731nT2(AbstractC20556sC7 abstractC20556sC7, long j) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        this.a = abstractC20556sC7;
        this.b = j;
    }

    public final long a() {
        return this.b;
    }

    public final AbstractC20556sC7 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17731nT2)) {
            return false;
        }
        C17731nT2 c17731nT2 = (C17731nT2) obj;
        return AbstractC13042fc3.d(this.a, c17731nT2.a) && this.b == c17731nT2.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        return "HandleWeakUpdate(update=" + this.a + ", date=" + this.b + Separators.RPAREN;
    }
}
