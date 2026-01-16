package ir.nasim;

import java.util.Comparator;

/* renamed from: ir.nasim.Np4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C6452Np4 implements Comparator {
    public static final C6452Np4 a = new C6452Np4();

    private C6452Np4() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        AbstractC13042fc3.i(comparable, "a");
        AbstractC13042fc3.i(comparable2, "b");
        return comparable.compareTo(comparable2);
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        return B16.a;
    }
}
