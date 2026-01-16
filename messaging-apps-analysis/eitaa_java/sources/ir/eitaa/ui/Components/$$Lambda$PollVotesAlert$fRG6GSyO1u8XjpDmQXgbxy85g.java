package ir.eitaa.ui.Components;

import ir.eitaa.ui.Components.PollVotesAlert;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: ir.eitaa.ui.Components.-$$Lambda$PollVotesAlert$fRG6GSyO1-u8XjpDm-QXgbxy85g, reason: invalid class name */
/* loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$PollVotesAlert$fRG6GSyO1u8XjpDmQXgbxy85g implements Comparator, j$.util.Comparator {
    public static final /* synthetic */ $$Lambda$PollVotesAlert$fRG6GSyO1u8XjpDmQXgbxy85g INSTANCE = new $$Lambda$PollVotesAlert$fRG6GSyO1u8XjpDmQXgbxy85g();

    private /* synthetic */ $$Lambda$PollVotesAlert$fRG6GSyO1u8XjpDmQXgbxy85g() {
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return PollVotesAlert.lambda$updateButtons$5((PollVotesAlert.Button) obj, (PollVotesAlert.Button) obj2);
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
