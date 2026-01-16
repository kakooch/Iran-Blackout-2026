package j$.wrappers;

import java.util.function.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class w0 implements j$.util.function.y {
    final /* synthetic */ Predicate a;

    private /* synthetic */ w0(Predicate predicate) {
        this.a = predicate;
    }

    public static /* synthetic */ j$.util.function.y c(Predicate predicate) {
        if (predicate == null) {
            return null;
        }
        return predicate instanceof x0 ? ((x0) predicate).a : new w0(predicate);
    }

    @Override // j$.util.function.y
    public /* synthetic */ j$.util.function.y a(j$.util.function.y yVar) {
        return c(this.a.or(x0.a(yVar)));
    }

    @Override // j$.util.function.y
    public /* synthetic */ j$.util.function.y b(j$.util.function.y yVar) {
        return c(this.a.and(x0.a(yVar)));
    }

    @Override // j$.util.function.y
    public /* synthetic */ j$.util.function.y negate() {
        return c(this.a.negate());
    }

    @Override // j$.util.function.y
    public /* synthetic */ boolean test(Object obj) {
        return this.a.test(obj);
    }
}
