package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class E66 implements InterfaceC15283jK {
    private final AbstractC20556sC7 a;

    public E66(AbstractC20556sC7 abstractC20556sC7) {
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
        return (obj instanceof E66) && AbstractC13042fc3.d(this.a, ((E66) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "RouterWalletUpdate(update=" + this.a + Separators.RPAREN;
    }
}
