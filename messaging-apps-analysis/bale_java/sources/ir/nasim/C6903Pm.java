package ir.nasim;

import ir.nasim.C24708z44;
import ir.nasim.InterfaceC12529em;

/* renamed from: ir.nasim.Pm, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6903Pm implements C24708z44.a {
    private final InterfaceC12529em.b a;
    private final InterfaceC12529em.b b;
    private final int c;

    public C6903Pm(InterfaceC12529em.b bVar, InterfaceC12529em.b bVar2, int i) {
        this.a = bVar;
        this.b = bVar2;
        this.c = i;
    }

    @Override // ir.nasim.C24708z44.a
    public int a(C25005za3 c25005za3, long j, int i, EnumC12613eu3 enumC12613eu3) {
        int iA = this.b.a(0, c25005za3.l(), enumC12613eu3);
        return c25005za3.g() + iA + (-this.a.a(0, i, enumC12613eu3)) + (enumC12613eu3 == EnumC12613eu3.a ? this.c : -this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6903Pm)) {
            return false;
        }
        C6903Pm c6903Pm = (C6903Pm) obj;
        return AbstractC13042fc3.d(this.a, c6903Pm.a) && AbstractC13042fc3.d(this.b, c6903Pm.b) && this.c == c6903Pm.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "Horizontal(menuAlignment=" + this.a + ", anchorAlignment=" + this.b + ", offset=" + this.c + ')';
    }
}
