package ir.eitaa.messenger;

import ir.eitaa.tgnet.TLRPC$TL_updateGroupCallParticipants;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$x6yKW3u_XSe7xOiuP2PADL2gmvI, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$ChatObject$Call$x6yKW3u_XSe7xOiuP2PADL2gmvI implements Comparator, j$.util.Comparator {
    public static final /* synthetic */ $$Lambda$ChatObject$Call$x6yKW3u_XSe7xOiuP2PADL2gmvI INSTANCE = new $$Lambda$ChatObject$Call$x6yKW3u_XSe7xOiuP2PADL2gmvI();

    private /* synthetic */ $$Lambda$ChatObject$Call$x6yKW3u_XSe7xOiuP2PADL2gmvI() {
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return AndroidUtilities.compare(((TLRPC$TL_updateGroupCallParticipants) obj).version, ((TLRPC$TL_updateGroupCallParticipants) obj2).version);
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
