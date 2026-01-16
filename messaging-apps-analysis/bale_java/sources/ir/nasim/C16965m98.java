package ir.nasim;

import ir.nasim.C24708z44;
import ir.nasim.InterfaceC12529em;

/* renamed from: ir.nasim.m98, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16965m98 implements C24708z44.a {
    private final InterfaceC12529em.b a;
    private final int b;

    public C16965m98(InterfaceC12529em.b bVar, int i) {
        this.a = bVar;
        this.b = i;
    }

    @Override // ir.nasim.C24708z44.a
    public int a(C25005za3 c25005za3, long j, int i, EnumC12613eu3 enumC12613eu3) {
        return i >= C4414Fa3.g(j) - (this.b * 2) ? InterfaceC12529em.a.g().a(i, C4414Fa3.g(j), enumC12613eu3) : AbstractC23053wG5.m(this.a.a(i, C4414Fa3.g(j), enumC12613eu3), this.b, (C4414Fa3.g(j) - this.b) - i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16965m98)) {
            return false;
        }
        C16965m98 c16965m98 = (C16965m98) obj;
        return AbstractC13042fc3.d(this.a, c16965m98.a) && this.b == c16965m98.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "Horizontal(alignment=" + this.a + ", margin=" + this.b + ')';
    }
}
