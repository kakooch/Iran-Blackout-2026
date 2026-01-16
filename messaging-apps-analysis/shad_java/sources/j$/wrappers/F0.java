package j$.wrappers;

import java.util.function.ToLongFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class F0 implements ToLongFunction {
    final /* synthetic */ j$.util.function.B a;

    private /* synthetic */ F0(j$.util.function.B b) {
        this.a = b;
    }

    public static /* synthetic */ ToLongFunction a(j$.util.function.B b) {
        if (b == null) {
            return null;
        }
        return b instanceof E0 ? ((E0) b).a : new F0(b);
    }

    @Override // java.util.function.ToLongFunction
    public /* synthetic */ long applyAsLong(Object obj) {
        return this.a.applyAsLong(obj);
    }
}
