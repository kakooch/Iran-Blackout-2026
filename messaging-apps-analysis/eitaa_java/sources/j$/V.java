package j$;

import java.util.function.IntPredicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class V implements j$.util.function.A {
    final /* synthetic */ IntPredicate a;

    private /* synthetic */ V(IntPredicate intPredicate) {
        this.a = intPredicate;
    }

    public static /* synthetic */ j$.util.function.A a(IntPredicate intPredicate) {
        if (intPredicate == null) {
            return null;
        }
        return intPredicate instanceof W ? ((W) intPredicate).a : new V(intPredicate);
    }

    public /* synthetic */ boolean b(int i) {
        return this.a.test(i);
    }
}
