package ir.eitaa.ui.Adapters;

import ir.eitaa.ui.Adapters.SearchAdapterHelper;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: ir.eitaa.ui.Adapters.-$$Lambda$SearchAdapterHelper$r94IEY_r67Tv7aeRoG6VTMvavVI, reason: invalid class name */
/* loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$SearchAdapterHelper$r94IEY_r67Tv7aeRoG6VTMvavVI implements Comparator, j$.util.Comparator {
    public static final /* synthetic */ $$Lambda$SearchAdapterHelper$r94IEY_r67Tv7aeRoG6VTMvavVI INSTANCE = new $$Lambda$SearchAdapterHelper$r94IEY_r67Tv7aeRoG6VTMvavVI();

    private /* synthetic */ $$Lambda$SearchAdapterHelper$r94IEY_r67Tv7aeRoG6VTMvavVI() {
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return SearchAdapterHelper.lambda$loadRecentHashtags$4((SearchAdapterHelper.HashtagObject) obj, (SearchAdapterHelper.HashtagObject) obj2);
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public /* synthetic */ Comparator reversed() {
        return Collections.reverseOrder(this);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ Comparator thenComparing(Function function) {
        return a.E(this, Comparator.CC.comparing(function));
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, function, comparator);
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, comparator);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
    }
}
