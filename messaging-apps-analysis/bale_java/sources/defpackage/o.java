package defpackage;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC14603iB2;

/* loaded from: classes.dex */
final class o {
    private final Object a;
    private final InterfaceC14603iB2 b;

    public o(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "content");
        this.a = obj;
        this.b = interfaceC14603iB2;
    }

    public final InterfaceC14603iB2 a() {
        return this.b;
    }

    public final Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return AbstractC13042fc3.d(this.a, oVar.a) && AbstractC13042fc3.d(this.b, oVar.b);
    }

    public int hashCode() {
        Object obj = this.a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "CircularRevealAnimationItem(key=" + this.a + ", content=" + this.b + Separators.RPAREN;
    }
}
