package j$;

import java.util.function.DoubleUnaryOperator;

/* loaded from: classes2.dex */
public final /* synthetic */ class K implements j$.util.function.w {
    final /* synthetic */ DoubleUnaryOperator a;

    private /* synthetic */ K(DoubleUnaryOperator doubleUnaryOperator) {
        this.a = doubleUnaryOperator;
    }

    public static /* synthetic */ j$.util.function.w b(DoubleUnaryOperator doubleUnaryOperator) {
        if (doubleUnaryOperator == null) {
            return null;
        }
        return doubleUnaryOperator instanceof L ? ((L) doubleUnaryOperator).a : new K(doubleUnaryOperator);
    }

    public /* synthetic */ double a(double d) {
        return this.a.applyAsDouble(d);
    }
}
