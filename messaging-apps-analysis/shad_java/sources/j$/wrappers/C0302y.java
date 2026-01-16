package j$.wrappers;

import java.util.function.DoubleBinaryOperator;

/* renamed from: j$.wrappers.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0302y implements DoubleBinaryOperator {
    final /* synthetic */ j$.util.function.d a;

    private /* synthetic */ C0302y(j$.util.function.d dVar) {
        this.a = dVar;
    }

    public static /* synthetic */ DoubleBinaryOperator a(j$.util.function.d dVar) {
        if (dVar == null) {
            return null;
        }
        return dVar instanceof C0301x ? ((C0301x) dVar).a : new C0302y(dVar);
    }

    @Override // java.util.function.DoubleBinaryOperator
    public /* synthetic */ double applyAsDouble(double d, double d2) {
        return this.a.applyAsDouble(d, d2);
    }
}
