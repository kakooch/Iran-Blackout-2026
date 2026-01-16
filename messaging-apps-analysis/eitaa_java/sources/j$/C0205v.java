package j$;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* renamed from: j$.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0205v implements BinaryOperator {
    final /* synthetic */ j$.util.function.p a;

    private /* synthetic */ C0205v(j$.util.function.p pVar) {
        this.a = pVar;
    }

    public static /* synthetic */ BinaryOperator a(j$.util.function.p pVar) {
        if (pVar == null) {
            return null;
        }
        return pVar instanceof C0089u ? ((C0089u) pVar).a : new C0205v(pVar);
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return C0088t.a(this.a.andThen(M.a(function)));
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.a.apply(obj, obj2);
    }
}
