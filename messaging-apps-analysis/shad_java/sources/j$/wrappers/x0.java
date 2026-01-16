package j$.wrappers;

import java.util.function.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class x0 implements Predicate {
    final /* synthetic */ j$.util.function.y a;

    private /* synthetic */ x0(j$.util.function.y yVar) {
        this.a = yVar;
    }

    public static /* synthetic */ Predicate a(j$.util.function.y yVar) {
        if (yVar == null) {
            return null;
        }
        return yVar instanceof w0 ? ((w0) yVar).a : new x0(yVar);
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        return a(this.a.b(w0.c(predicate)));
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate negate() {
        return a(this.a.negate());
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        return a(this.a.a(w0.c(predicate)));
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ boolean test(Object obj) {
        return this.a.test(obj);
    }
}
