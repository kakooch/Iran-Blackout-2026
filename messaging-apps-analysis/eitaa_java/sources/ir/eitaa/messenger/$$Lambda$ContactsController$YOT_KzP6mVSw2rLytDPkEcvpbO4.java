package ir.eitaa.messenger;

import androidx.collection.LongSparseArray;
import ir.eitaa.tgnet.TLRPC$TL_contact;
import ir.eitaa.tgnet.TLRPC$User;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: ir.eitaa.messenger.-$$Lambda$ContactsController$YOT_KzP6mVSw2rLytDPkEcvpbO4, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$ContactsController$YOT_KzP6mVSw2rLytDPkEcvpbO4 implements Comparator, j$.util.Comparator {
    public final /* synthetic */ LongSparseArray f$0;

    public /* synthetic */ $$Lambda$ContactsController$YOT_KzP6mVSw2rLytDPkEcvpbO4(LongSparseArray longSparseArray) {
        this.f$0 = longSparseArray;
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final int compare(Object obj, Object obj2) {
        LongSparseArray longSparseArray = this.f$0;
        return UserObject.getFirstName((TLRPC$User) longSparseArray.get(((TLRPC$TL_contact) obj).user_id)).compareTo(UserObject.getFirstName((TLRPC$User) longSparseArray.get(((TLRPC$TL_contact) obj2).user_id)));
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
