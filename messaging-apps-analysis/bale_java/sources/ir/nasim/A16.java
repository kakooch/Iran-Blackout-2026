package ir.nasim;

import java.io.Serializable;

/* loaded from: classes3.dex */
final class A16 extends UL4 implements Serializable {
    static final A16 a = new A16();

    private A16() {
    }

    @Override // ir.nasim.UL4
    public UL4 d() {
        return UL4.b();
    }

    @Override // ir.nasim.UL4, java.util.Comparator
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        AbstractC4029Dj5.j(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
