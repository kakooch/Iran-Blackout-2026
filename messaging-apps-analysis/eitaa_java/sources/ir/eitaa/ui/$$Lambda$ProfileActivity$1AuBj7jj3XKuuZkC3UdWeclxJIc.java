package ir.eitaa.ui;

import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: ir.eitaa.ui.-$$Lambda$ProfileActivity$1AuBj7jj3XKuuZkC3UdWeclxJIc, reason: invalid class name */
/* loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$ProfileActivity$1AuBj7jj3XKuuZkC3UdWeclxJIc implements Comparator, j$.util.Comparator {
    public final /* synthetic */ ProfileActivity f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ $$Lambda$ProfileActivity$1AuBj7jj3XKuuZkC3UdWeclxJIc(ProfileActivity profileActivity, int i) {
        this.f$0 = profileActivity;
        this.f$1 = i;
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f$0.lambda$updateOnlineCount$27$ProfileActivity(this.f$1, (Integer) obj, (Integer) obj2);
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
