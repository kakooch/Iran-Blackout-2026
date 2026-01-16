package j$;

import java.util.function.IntToLongFunction;

/* renamed from: j$.a0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0053a0 implements IntToLongFunction {
    final /* synthetic */ j$.util.function.B a;

    private /* synthetic */ C0053a0(j$.util.function.B b) {
        this.a = b;
    }

    public static /* synthetic */ IntToLongFunction a(j$.util.function.B b) {
        if (b == null) {
            return null;
        }
        return b instanceof Z ? ((Z) b).a : new C0053a0(b);
    }

    @Override // java.util.function.IntToLongFunction
    public /* synthetic */ long applyAsLong(int i) {
        return this.a.applyAsLong(i);
    }
}
