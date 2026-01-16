package ir.nasim;

import ir.nasim.C24708z44;
import ir.nasim.InterfaceC12529em;

/* renamed from: ir.nasim.Qm, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7147Qm implements C24708z44.b {
    private final InterfaceC12529em.c a;
    private final InterfaceC12529em.c b;
    private final int c;

    public C7147Qm(InterfaceC12529em.c cVar, InterfaceC12529em.c cVar2, int i) {
        this.a = cVar;
        this.b = cVar2;
        this.c = i;
    }

    @Override // ir.nasim.C24708z44.b
    public int a(C25005za3 c25005za3, long j, int i) {
        int iA = this.b.a(0, c25005za3.f());
        return c25005za3.j() + iA + (-this.a.a(0, i)) + this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7147Qm)) {
            return false;
        }
        C7147Qm c7147Qm = (C7147Qm) obj;
        return AbstractC13042fc3.d(this.a, c7147Qm.a) && AbstractC13042fc3.d(this.b, c7147Qm.b) && this.c == c7147Qm.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "Vertical(menuAlignment=" + this.a + ", anchorAlignment=" + this.b + ", offset=" + this.c + ')';
    }
}
