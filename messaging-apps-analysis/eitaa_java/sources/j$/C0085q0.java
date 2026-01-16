package j$;

import java.util.function.LongUnaryOperator;

/* renamed from: j$.q0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0085q0 implements LongUnaryOperator {
    final /* synthetic */ j$.util.function.H a;

    private /* synthetic */ C0085q0(j$.util.function.H h) {
        this.a = h;
    }

    public static /* synthetic */ LongUnaryOperator a(j$.util.function.H h) {
        if (h == null) {
            return null;
        }
        return h instanceof C0083p0 ? ((C0083p0) h).a : new C0085q0(h);
    }

    @Override // java.util.function.LongUnaryOperator
    public /* synthetic */ LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator) {
        return a(this.a.a(C0083p0.c(longUnaryOperator)));
    }

    @Override // java.util.function.LongUnaryOperator
    public /* synthetic */ long applyAsLong(long j) {
        return this.a.applyAsLong(j);
    }

    @Override // java.util.function.LongUnaryOperator
    public /* synthetic */ LongUnaryOperator compose(LongUnaryOperator longUnaryOperator) {
        return a(this.a.b(C0083p0.c(longUnaryOperator)));
    }
}
