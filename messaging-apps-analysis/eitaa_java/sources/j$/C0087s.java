package j$;

import j$.util.function.BiFunction;
import j$.util.function.Function;

/* renamed from: j$.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0087s implements BiFunction {
    final /* synthetic */ java.util.function.BiFunction a;

    private /* synthetic */ C0087s(java.util.function.BiFunction biFunction) {
        this.a = biFunction;
    }

    public static /* synthetic */ BiFunction a(java.util.function.BiFunction biFunction) {
        if (biFunction == null) {
            return null;
        }
        return biFunction instanceof C0088t ? ((C0088t) biFunction).a : new C0087s(biFunction);
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return a(this.a.andThen(N.a(function)));
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.a.apply(obj, obj2);
    }
}
