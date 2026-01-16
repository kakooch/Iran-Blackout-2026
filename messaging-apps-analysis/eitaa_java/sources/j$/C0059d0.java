package j$;

import java.util.function.LongBinaryOperator;

/* renamed from: j$.d0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0059d0 implements j$.util.function.D {
    final /* synthetic */ LongBinaryOperator a;

    private /* synthetic */ C0059d0(LongBinaryOperator longBinaryOperator) {
        this.a = longBinaryOperator;
    }

    public static /* synthetic */ j$.util.function.D a(LongBinaryOperator longBinaryOperator) {
        if (longBinaryOperator == null) {
            return null;
        }
        return longBinaryOperator instanceof C0061e0 ? ((C0061e0) longBinaryOperator).a : new C0059d0(longBinaryOperator);
    }

    @Override // j$.util.function.D
    public /* synthetic */ long applyAsLong(long j, long j2) {
        return this.a.applyAsLong(j, j2);
    }
}
