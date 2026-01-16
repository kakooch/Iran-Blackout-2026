package j$;

import java.util.function.LongPredicate;

/* renamed from: j$.k0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0073k0 implements LongPredicate {
    final /* synthetic */ j$.util.function.G a;

    private /* synthetic */ C0073k0(j$.util.function.G g) {
        this.a = g;
    }

    public static /* synthetic */ LongPredicate a(j$.util.function.G g) {
        if (g == null) {
            return null;
        }
        return g instanceof C0071j0 ? ((C0071j0) g).a : new C0073k0(g);
    }

    @Override // java.util.function.LongPredicate
    public /* synthetic */ LongPredicate and(LongPredicate longPredicate) {
        return a(C0071j0.a(((C0071j0) this.a).a.and(a(C0071j0.a(longPredicate)))));
    }

    @Override // java.util.function.LongPredicate
    public /* synthetic */ LongPredicate negate() {
        return a(C0071j0.a(((C0071j0) this.a).a.negate()));
    }

    @Override // java.util.function.LongPredicate
    public /* synthetic */ LongPredicate or(LongPredicate longPredicate) {
        return a(C0071j0.a(((C0071j0) this.a).a.or(a(C0071j0.a(longPredicate)))));
    }

    @Override // java.util.function.LongPredicate
    public /* synthetic */ boolean test(long j) {
        return ((C0071j0) this.a).a.test(j);
    }
}
