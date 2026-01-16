package ir.nasim;

import java.util.Comparator;

/* loaded from: classes8.dex */
final class B16 implements Comparator {
    public static final B16 a = new B16();

    private B16() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        AbstractC13042fc3.i(comparable, "a");
        AbstractC13042fc3.i(comparable2, "b");
        return comparable2.compareTo(comparable);
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        return C6452Np4.a;
    }
}
