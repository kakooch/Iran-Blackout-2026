package ir.nasim;

import java.io.Serializable;

/* loaded from: classes3.dex */
final class C16 extends UL4 implements Serializable {
    final UL4 a;

    C16(UL4 ul4) {
        this.a = (UL4) AbstractC4029Dj5.j(ul4);
    }

    @Override // ir.nasim.UL4, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.a.compare(obj2, obj);
    }

    @Override // ir.nasim.UL4
    public UL4 d() {
        return this.a;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C16) {
            return this.a.equals(((C16) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return -this.a.hashCode();
    }

    public String toString() {
        String strValueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 10);
        sb.append(strValueOf);
        sb.append(".reverse()");
        return sb.toString();
    }
}
