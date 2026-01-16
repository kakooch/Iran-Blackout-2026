package j$.wrappers;

import j$.util.function.BiFunction;
import j$.util.function.Function;

/* renamed from: j$.wrappers.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0296s implements BiFunction {
    final /* synthetic */ java.util.function.BiFunction a;

    private /* synthetic */ C0296s(java.util.function.BiFunction biFunction) {
        this.a = biFunction;
    }

    public static /* synthetic */ BiFunction a(java.util.function.BiFunction biFunction) {
        if (biFunction == null) {
            return null;
        }
        return biFunction instanceof C0297t ? ((C0297t) biFunction).a : new C0296s(biFunction);
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return a(this.a.andThen(M.a(function)));
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.a.apply(obj, obj2);
    }
}
