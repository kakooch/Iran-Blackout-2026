package ir.eitaa.messenger;

import ir.eitaa.messenger.ChatObject;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$JTf8l2zEdcDNWBcmMvVdHz-2OvU, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$ChatObject$Call$JTf8l2zEdcDNWBcmMvVdHz2OvU implements Comparator, j$.util.Comparator {
    public final /* synthetic */ ChatObject.Call f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ $$Lambda$ChatObject$Call$JTf8l2zEdcDNWBcmMvVdHz2OvU(ChatObject.Call call, long j, boolean z) {
        this.f$0 = call;
        this.f$1 = j;
        this.f$2 = z;
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f$0.lambda$sortParticipants$11$ChatObject$Call(this.f$1, this.f$2, (TLRPC$TL_groupCallParticipant) obj, (TLRPC$TL_groupCallParticipant) obj2);
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
