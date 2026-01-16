package ir.nasim;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: ir.nasim.j01, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C15095j01 extends UL4 implements Serializable {
    final Comparator a;

    C15095j01(Comparator comparator) {
        this.a = (Comparator) AbstractC4029Dj5.j(comparator);
    }

    @Override // ir.nasim.UL4, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C15095j01) {
            return this.a.equals(((C15095j01) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
