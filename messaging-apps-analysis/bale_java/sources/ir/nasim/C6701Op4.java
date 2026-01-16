package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.Op4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C6701Op4 extends UL4 implements Serializable {
    static final C6701Op4 a = new C6701Op4();

    private C6701Op4() {
    }

    @Override // ir.nasim.UL4
    public UL4 d() {
        return A16.a;
    }

    @Override // ir.nasim.UL4, java.util.Comparator
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        AbstractC4029Dj5.j(comparable);
        AbstractC4029Dj5.j(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
