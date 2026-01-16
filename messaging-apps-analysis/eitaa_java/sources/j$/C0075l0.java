package j$;

import java.util.function.LongToDoubleFunction;

/* renamed from: j$.l0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0075l0 {
    final /* synthetic */ LongToDoubleFunction a;

    private /* synthetic */ C0075l0(LongToDoubleFunction longToDoubleFunction) {
        this.a = longToDoubleFunction;
    }

    public static /* synthetic */ C0075l0 b(LongToDoubleFunction longToDoubleFunction) {
        if (longToDoubleFunction == null) {
            return null;
        }
        return longToDoubleFunction instanceof C0077m0 ? ((C0077m0) longToDoubleFunction).a : new C0075l0(longToDoubleFunction);
    }

    public double a(long j) {
        return this.a.applyAsDouble(j);
    }
}
