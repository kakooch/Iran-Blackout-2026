package j$.wrappers;

import java.util.function.ToDoubleFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class B0 implements ToDoubleFunction {
    final /* synthetic */ j$.util.function.A a;

    private /* synthetic */ B0(j$.util.function.A a) {
        this.a = a;
    }

    public static /* synthetic */ ToDoubleFunction a(j$.util.function.A a) {
        if (a == null) {
            return null;
        }
        return a instanceof A0 ? ((A0) a).a : new B0(a);
    }

    @Override // java.util.function.ToDoubleFunction
    public /* synthetic */ double applyAsDouble(Object obj) {
        return this.a.applyAsDouble(obj);
    }
}
