package j$;

import java.util.function.DoubleBinaryOperator;

/* renamed from: j$.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0209z implements DoubleBinaryOperator {
    final /* synthetic */ j$.util.function.r a;

    private /* synthetic */ C0209z(j$.util.function.r rVar) {
        this.a = rVar;
    }

    public static /* synthetic */ DoubleBinaryOperator a(j$.util.function.r rVar) {
        if (rVar == null) {
            return null;
        }
        return rVar instanceof C0208y ? ((C0208y) rVar).a : new C0209z(rVar);
    }

    @Override // java.util.function.DoubleBinaryOperator
    public /* synthetic */ double applyAsDouble(double d, double d2) {
        return this.a.applyAsDouble(d, d2);
    }
}
