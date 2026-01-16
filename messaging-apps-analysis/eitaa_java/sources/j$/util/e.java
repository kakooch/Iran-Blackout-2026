package j$.util;

import j$.B0;
import j$.D0;
import j$.F0;
import j$.M;
import j$.util.Comparator;
import j$.util.function.ToIntFunction;
import java.io.Serializable;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class e implements java.util.Comparator, Serializable {
    public final /* synthetic */ ToIntFunction a;

    public /* synthetic */ e(ToIntFunction toIntFunction) {
        this.a = toIntFunction;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ToIntFunction toIntFunction = this.a;
        return j$.time.a.v(toIntFunction.applyAsInt(obj), toIntFunction.applyAsInt(obj2));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator reversed() {
        return Collections.reverseOrder(this);
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, comparator);
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return j$.time.a.E(this, Comparator.CC.comparing(M.a(function)));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, B0.a(toDoubleFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingInt(java.util.function.ToIntFunction toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, D0.a(toIntFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, F0.a(toLongFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, M.a(function), comparator);
    }
}
