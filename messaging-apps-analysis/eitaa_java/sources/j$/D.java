package j$;

import java.util.function.DoubleFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class D implements DoubleFunction {
    final /* synthetic */ j$.util.function.t a;

    private /* synthetic */ D(j$.util.function.t tVar) {
        this.a = tVar;
    }

    public static /* synthetic */ DoubleFunction a(j$.util.function.t tVar) {
        if (tVar == null) {
            return null;
        }
        return tVar instanceof C ? ((C) tVar).a : new D(tVar);
    }

    @Override // java.util.function.DoubleFunction
    public /* synthetic */ Object apply(double d) {
        return this.a.apply(d);
    }
}
