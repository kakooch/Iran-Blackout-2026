package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.Serializable;

/* renamed from: ir.nasim.uo0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C22182uo0 extends UL4 implements Serializable {
    final InterfaceC15205jB2 a;
    final UL4 b;

    C22182uo0(InterfaceC15205jB2 interfaceC15205jB2, UL4 ul4) {
        this.a = (InterfaceC15205jB2) AbstractC4029Dj5.j(interfaceC15205jB2);
        this.b = (UL4) AbstractC4029Dj5.j(ul4);
    }

    @Override // ir.nasim.UL4, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.b.compare(this.a.apply(obj), this.a.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C22182uo0)) {
            return false;
        }
        C22182uo0 c22182uo0 = (C22182uo0) obj;
        return this.a.equals(c22182uo0.a) && this.b.equals(c22182uo0.b);
    }

    public int hashCode() {
        return EG4.b(this.a, this.b);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.b);
        String strValueOf2 = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 13 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append(".onResultOf(");
        sb.append(strValueOf2);
        sb.append(Separators.RPAREN);
        return sb.toString();
    }
}
