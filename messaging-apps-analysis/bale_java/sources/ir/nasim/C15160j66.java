package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.j66, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15160j66 implements InterfaceC15283jK {
    private final AbstractC20556sC7 a;

    public C15160j66(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        this.a = abstractC20556sC7;
    }

    public final AbstractC20556sC7 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C15160j66) && AbstractC13042fc3.d(this.a, ((C15160j66) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "RouterGroupUpdate(update=" + this.a + Separators.RPAREN;
    }
}
