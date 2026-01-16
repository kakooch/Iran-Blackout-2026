package j$;

import java.util.function.DoubleUnaryOperator;

/* loaded from: classes2.dex */
public final /* synthetic */ class L implements DoubleUnaryOperator {
    final /* synthetic */ j$.util.function.w a;

    private /* synthetic */ L(j$.util.function.w wVar) {
        this.a = wVar;
    }

    public static /* synthetic */ DoubleUnaryOperator a(j$.util.function.w wVar) {
        if (wVar == null) {
            return null;
        }
        return wVar instanceof K ? ((K) wVar).a : new L(wVar);
    }

    @Override // java.util.function.DoubleUnaryOperator
    public /* synthetic */ DoubleUnaryOperator andThen(DoubleUnaryOperator doubleUnaryOperator) {
        return a(K.b(((K) this.a).a.andThen(a(K.b(doubleUnaryOperator)))));
    }

    @Override // java.util.function.DoubleUnaryOperator
    public /* synthetic */ double applyAsDouble(double d) {
        return ((K) this.a).a.applyAsDouble(d);
    }

    @Override // java.util.function.DoubleUnaryOperator
    public /* synthetic */ DoubleUnaryOperator compose(DoubleUnaryOperator doubleUnaryOperator) {
        return a(K.b(((K) this.a).a.compose(a(K.b(doubleUnaryOperator)))));
    }
}
