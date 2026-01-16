package ir.nasim;

import ir.nasim.C24708z44;
import ir.nasim.InterfaceC12529em;

/* renamed from: ir.nasim.n98, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17556n98 implements C24708z44.b {
    private final InterfaceC12529em.c a;
    private final int b;

    public C17556n98(InterfaceC12529em.c cVar, int i) {
        this.a = cVar;
        this.b = i;
    }

    @Override // ir.nasim.C24708z44.b
    public int a(C25005za3 c25005za3, long j, int i) {
        return i >= C4414Fa3.f(j) - (this.b * 2) ? InterfaceC12529em.a.i().a(i, C4414Fa3.f(j)) : AbstractC23053wG5.m(this.a.a(i, C4414Fa3.f(j)), this.b, (C4414Fa3.f(j) - this.b) - i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17556n98)) {
            return false;
        }
        C17556n98 c17556n98 = (C17556n98) obj;
        return AbstractC13042fc3.d(this.a, c17556n98.a) && this.b == c17556n98.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "Vertical(alignment=" + this.a + ", margin=" + this.b + ')';
    }
}
