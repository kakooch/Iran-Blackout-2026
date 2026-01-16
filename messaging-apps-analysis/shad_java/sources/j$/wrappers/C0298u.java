package j$.wrappers;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.InterfaceC0109b;
import java.util.function.BinaryOperator;

/* renamed from: j$.wrappers.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0298u implements InterfaceC0109b {
    final /* synthetic */ BinaryOperator a;

    private /* synthetic */ C0298u(BinaryOperator binaryOperator) {
        this.a = binaryOperator;
    }

    public static /* synthetic */ InterfaceC0109b a(BinaryOperator binaryOperator) {
        if (binaryOperator == null) {
            return null;
        }
        return binaryOperator instanceof C0299v ? ((C0299v) binaryOperator).a : new C0298u(binaryOperator);
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return C0296s.a(this.a.andThen(M.a(function)));
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.a.apply(obj, obj2);
    }
}
