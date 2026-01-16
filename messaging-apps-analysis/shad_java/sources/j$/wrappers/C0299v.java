package j$.wrappers;

import j$.util.function.InterfaceC0109b;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* renamed from: j$.wrappers.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0299v implements BinaryOperator {
    final /* synthetic */ InterfaceC0109b a;

    private /* synthetic */ C0299v(InterfaceC0109b interfaceC0109b) {
        this.a = interfaceC0109b;
    }

    public static /* synthetic */ BinaryOperator a(InterfaceC0109b interfaceC0109b) {
        if (interfaceC0109b == null) {
            return null;
        }
        return interfaceC0109b instanceof C0298u ? ((C0298u) interfaceC0109b).a : new C0299v(interfaceC0109b);
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return C0297t.a(this.a.andThen(L.a(function)));
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.a.apply(obj, obj2);
    }
}
