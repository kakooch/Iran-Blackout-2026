package ir.eitaa.ui.Adapters;

import ir.eitaa.messenger.MessagesController;
import ir.eitaa.tgnet.TLRPC$TL_contact;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: ir.eitaa.ui.Adapters.-$$Lambda$DialogsAdapter$Ffc8LVpDgIa364cQKq8GrPs3CQg, reason: invalid class name */
/* loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$DialogsAdapter$Ffc8LVpDgIa364cQKq8GrPs3CQg implements Comparator, j$.util.Comparator {
    public final /* synthetic */ MessagesController f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ $$Lambda$DialogsAdapter$Ffc8LVpDgIa364cQKq8GrPs3CQg(MessagesController messagesController, int i) {
        this.f$0 = messagesController;
        this.f$1 = i;
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return DialogsAdapter.lambda$sortOnlineContacts$0(this.f$0, this.f$1, (TLRPC$TL_contact) obj, (TLRPC$TL_contact) obj2);
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
