package j$.wrappers;

import java.util.function.DoubleBinaryOperator;

/* renamed from: j$.wrappers.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0301x implements j$.util.function.d {
    final /* synthetic */ DoubleBinaryOperator a;

    private /* synthetic */ C0301x(DoubleBinaryOperator doubleBinaryOperator) {
        this.a = doubleBinaryOperator;
    }

    public static /* synthetic */ j$.util.function.d a(DoubleBinaryOperator doubleBinaryOperator) {
        if (doubleBinaryOperator == null) {
            return null;
        }
        return doubleBinaryOperator instanceof C0302y ? ((C0302y) doubleBinaryOperator).a : new C0301x(doubleBinaryOperator);
    }

    @Override // j$.util.function.d
    public /* synthetic */ double applyAsDouble(double d, double d2) {
        return this.a.applyAsDouble(d, d2);
    }
}
