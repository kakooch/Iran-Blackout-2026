package j$;

import java.util.function.LongUnaryOperator;

/* renamed from: j$.p0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0083p0 implements j$.util.function.H {
    final /* synthetic */ LongUnaryOperator a;

    private /* synthetic */ C0083p0(LongUnaryOperator longUnaryOperator) {
        this.a = longUnaryOperator;
    }

    public static /* synthetic */ j$.util.function.H c(LongUnaryOperator longUnaryOperator) {
        if (longUnaryOperator == null) {
            return null;
        }
        return longUnaryOperator instanceof C0085q0 ? ((C0085q0) longUnaryOperator).a : new C0083p0(longUnaryOperator);
    }

    @Override // j$.util.function.H
    public /* synthetic */ j$.util.function.H a(j$.util.function.H h) {
        return c(this.a.andThen(C0085q0.a(h)));
    }

    @Override // j$.util.function.H
    public /* synthetic */ long applyAsLong(long j) {
        return this.a.applyAsLong(j);
    }

    @Override // j$.util.function.H
    public /* synthetic */ j$.util.function.H b(j$.util.function.H h) {
        return c(this.a.compose(C0085q0.a(h)));
    }
}
