package j$;

import java.util.function.IntBinaryOperator;

/* loaded from: classes2.dex */
public final /* synthetic */ class P implements IntBinaryOperator {
    final /* synthetic */ j$.util.function.x a;

    private /* synthetic */ P(j$.util.function.x xVar) {
        this.a = xVar;
    }

    public static /* synthetic */ IntBinaryOperator a(j$.util.function.x xVar) {
        if (xVar == null) {
            return null;
        }
        return xVar instanceof O ? ((O) xVar).a : new P(xVar);
    }

    @Override // java.util.function.IntBinaryOperator
    public /* synthetic */ int applyAsInt(int i, int i2) {
        return this.a.applyAsInt(i, i2);
    }
}
