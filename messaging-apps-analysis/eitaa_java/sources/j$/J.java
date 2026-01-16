package j$;

import java.util.function.DoubleToLongFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class J implements DoubleToLongFunction {
    final /* synthetic */ j$.util.function.v a;

    private /* synthetic */ J(j$.util.function.v vVar) {
        this.a = vVar;
    }

    public static /* synthetic */ DoubleToLongFunction a(j$.util.function.v vVar) {
        if (vVar == null) {
            return null;
        }
        return vVar instanceof I ? ((I) vVar).a : new J(vVar);
    }

    @Override // java.util.function.DoubleToLongFunction
    public /* synthetic */ long applyAsLong(double d) {
        return this.a.applyAsLong(d);
    }
}
