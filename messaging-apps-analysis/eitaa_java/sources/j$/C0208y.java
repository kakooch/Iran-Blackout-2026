package j$;

import java.util.function.DoubleBinaryOperator;

/* renamed from: j$.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0208y implements j$.util.function.r {
    final /* synthetic */ DoubleBinaryOperator a;

    private /* synthetic */ C0208y(DoubleBinaryOperator doubleBinaryOperator) {
        this.a = doubleBinaryOperator;
    }

    public static /* synthetic */ j$.util.function.r a(DoubleBinaryOperator doubleBinaryOperator) {
        if (doubleBinaryOperator == null) {
            return null;
        }
        return doubleBinaryOperator instanceof C0209z ? ((C0209z) doubleBinaryOperator).a : new C0208y(doubleBinaryOperator);
    }

    @Override // j$.util.function.r
    public /* synthetic */ double applyAsDouble(double d, double d2) {
        return this.a.applyAsDouble(d, d2);
    }
}
