package j$.wrappers;

import java.util.function.LongToDoubleFunction;

/* renamed from: j$.wrappers.k0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0284k0 {
    final /* synthetic */ LongToDoubleFunction a;

    private /* synthetic */ C0284k0(LongToDoubleFunction longToDoubleFunction) {
        this.a = longToDoubleFunction;
    }

    public static /* synthetic */ C0284k0 b(LongToDoubleFunction longToDoubleFunction) {
        if (longToDoubleFunction == null) {
            return null;
        }
        return longToDoubleFunction instanceof AbstractC0286l0 ? ((AbstractC0286l0) longToDoubleFunction).a : new C0284k0(longToDoubleFunction);
    }

    public double a(long j) {
        return this.a.applyAsDouble(j);
    }
}
