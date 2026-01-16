package ir.eitaa.messenger;

import ir.eitaa.tgnet.TLRPC$TL_topPeer;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: ir.eitaa.messenger.-$$Lambda$MediaDataController$nexFFsO9q7IfSusqNuCCWSyC0RY, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$MediaDataController$nexFFsO9q7IfSusqNuCCWSyC0RY implements Comparator, j$.util.Comparator {
    public static final /* synthetic */ $$Lambda$MediaDataController$nexFFsO9q7IfSusqNuCCWSyC0RY INSTANCE = new $$Lambda$MediaDataController$nexFFsO9q7IfSusqNuCCWSyC0RY();

    private /* synthetic */ $$Lambda$MediaDataController$nexFFsO9q7IfSusqNuCCWSyC0RY() {
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return MediaDataController.lambda$increasePeerRaiting$98((TLRPC$TL_topPeer) obj, (TLRPC$TL_topPeer) obj2);
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
