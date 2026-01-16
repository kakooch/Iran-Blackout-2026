package j$;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.function.BinaryOperator;

/* renamed from: j$.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0089u implements j$.util.function.p {
    final /* synthetic */ BinaryOperator a;

    private /* synthetic */ C0089u(BinaryOperator binaryOperator) {
        this.a = binaryOperator;
    }

    public static /* synthetic */ j$.util.function.p a(BinaryOperator binaryOperator) {
        if (binaryOperator == null) {
            return null;
        }
        return binaryOperator instanceof C0205v ? ((C0205v) binaryOperator).a : new C0089u(binaryOperator);
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return C0087s.a(this.a.andThen(N.a(function)));
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.a.apply(obj, obj2);
    }
}
