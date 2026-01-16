package j$.wrappers;

import java.util.function.ToDoubleFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class A0 implements j$.util.function.A {
    final /* synthetic */ ToDoubleFunction a;

    private /* synthetic */ A0(ToDoubleFunction toDoubleFunction) {
        this.a = toDoubleFunction;
    }

    public static /* synthetic */ j$.util.function.A a(ToDoubleFunction toDoubleFunction) {
        if (toDoubleFunction == null) {
            return null;
        }
        return toDoubleFunction instanceof B0 ? ((B0) toDoubleFunction).a : new A0(toDoubleFunction);
    }

    @Override // j$.util.function.A
    public /* synthetic */ double applyAsDouble(Object obj) {
        return this.a.applyAsDouble(obj);
    }
}
