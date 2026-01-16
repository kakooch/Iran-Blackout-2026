package j$;

import java.util.function.IntPredicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class W implements IntPredicate {
    final /* synthetic */ j$.util.function.A a;

    private /* synthetic */ W(j$.util.function.A a) {
        this.a = a;
    }

    public static /* synthetic */ IntPredicate a(j$.util.function.A a) {
        if (a == null) {
            return null;
        }
        return a instanceof V ? ((V) a).a : new W(a);
    }

    @Override // java.util.function.IntPredicate
    public /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
        return a(V.a(((V) this.a).a.and(a(V.a(intPredicate)))));
    }

    @Override // java.util.function.IntPredicate
    public /* synthetic */ IntPredicate negate() {
        return a(V.a(((V) this.a).a.negate()));
    }

    @Override // java.util.function.IntPredicate
    public /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
        return a(V.a(((V) this.a).a.or(a(V.a(intPredicate)))));
    }

    @Override // java.util.function.IntPredicate
    public /* synthetic */ boolean test(int i) {
        return ((V) this.a).a.test(i);
    }
}
