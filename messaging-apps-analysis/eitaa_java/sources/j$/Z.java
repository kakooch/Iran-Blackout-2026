package j$;

import java.util.function.IntToLongFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class Z implements j$.util.function.B {
    final /* synthetic */ IntToLongFunction a;

    private /* synthetic */ Z(IntToLongFunction intToLongFunction) {
        this.a = intToLongFunction;
    }

    public static /* synthetic */ j$.util.function.B a(IntToLongFunction intToLongFunction) {
        if (intToLongFunction == null) {
            return null;
        }
        return intToLongFunction instanceof C0053a0 ? ((C0053a0) intToLongFunction).a : new Z(intToLongFunction);
    }

    @Override // j$.util.function.B
    public /* synthetic */ long applyAsLong(int i) {
        return this.a.applyAsLong(i);
    }
}
