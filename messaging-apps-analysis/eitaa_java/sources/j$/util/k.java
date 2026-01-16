package j$.util;

import j$.B0;
import j$.D0;
import j$.F0;
import j$.M;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;

/* loaded from: classes2.dex */
enum k implements java.util.Comparator<Comparable<Object>>, Comparator {
    INSTANCE;

    @Override // java.util.Comparator, j$.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo((Comparable) obj2);
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public java.util.Comparator reversed() {
        return Comparator.CC.reverseOrder();
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return j$.time.a.E(this, Comparator.CC.comparing(function));
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, function, comparator);
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, comparator);
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator<Comparable<Object>> thenComparing(java.util.function.Function function) {
        return j$.time.a.E(this, Comparator.CC.comparing(M.a(function)));
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator<Comparable<Object>> thenComparingDouble(java.util.function.ToDoubleFunction<? super Comparable<Object>> toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, B0.a(toDoubleFunction));
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator<Comparable<Object>> thenComparingInt(java.util.function.ToIntFunction<? super Comparable<Object>> toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, D0.a(toIntFunction));
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator<Comparable<Object>> thenComparingLong(java.util.function.ToLongFunction<? super Comparable<Object>> toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, F0.a(toLongFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator<Comparable<Object>> thenComparing(java.util.function.Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, M.a(function), comparator);
    }
}
