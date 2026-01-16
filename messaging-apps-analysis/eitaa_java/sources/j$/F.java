package j$;

import java.util.function.DoublePredicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class F implements DoublePredicate {
    final /* synthetic */ j$.util.function.u a;

    private /* synthetic */ F(j$.util.function.u uVar) {
        this.a = uVar;
    }

    public static /* synthetic */ DoublePredicate a(j$.util.function.u uVar) {
        if (uVar == null) {
            return null;
        }
        return uVar instanceof E ? ((E) uVar).a : new F(uVar);
    }

    @Override // java.util.function.DoublePredicate
    public /* synthetic */ DoublePredicate and(DoublePredicate doublePredicate) {
        return a(E.a(((E) this.a).a.and(a(E.a(doublePredicate)))));
    }

    @Override // java.util.function.DoublePredicate
    public /* synthetic */ DoublePredicate negate() {
        return a(E.a(((E) this.a).a.negate()));
    }

    @Override // java.util.function.DoublePredicate
    public /* synthetic */ DoublePredicate or(DoublePredicate doublePredicate) {
        return a(E.a(((E) this.a).a.or(a(E.a(doublePredicate)))));
    }

    @Override // java.util.function.DoublePredicate
    public /* synthetic */ boolean test(double d) {
        return ((E) this.a).a.test(d);
    }
}
