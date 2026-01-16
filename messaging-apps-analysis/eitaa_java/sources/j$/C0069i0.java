package j$;

import java.util.function.LongFunction;

/* renamed from: j$.i0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0069i0 implements LongFunction {
    final /* synthetic */ j$.util.function.F a;

    private /* synthetic */ C0069i0(j$.util.function.F f) {
        this.a = f;
    }

    public static /* synthetic */ LongFunction a(j$.util.function.F f) {
        if (f == null) {
            return null;
        }
        return f instanceof C0067h0 ? ((C0067h0) f).a : new C0069i0(f);
    }

    @Override // java.util.function.LongFunction
    public /* synthetic */ Object apply(long j) {
        return this.a.apply(j);
    }
}
